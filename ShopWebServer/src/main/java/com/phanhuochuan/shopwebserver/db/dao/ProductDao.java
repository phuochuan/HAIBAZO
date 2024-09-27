package com.phanhuochuan.shopwebserver.db.dao;

import com.phanhuochuan.shopwebserver.dto.SimpleProductPublicData;
import com.phanhuochuan.shopwebserver.entity.ProductStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class ProductDao {
    private static final Logger log = LoggerFactory.getLogger(ProductDao.class);
    private final EntityManager entityManager;

    public Page<SimpleProductPublicData> findAllByFilterCriteria(Pageable pageable, Map<String, String> filterCriteria) {
        String keyword=filterCriteria.get("keyword");
        keyword=keyword!=null?keyword.toLowerCase():"";
        filterCriteria.remove("keyword");
        StringBuilder jpql = new StringBuilder("""
                        SELECT new com.phanhuochuan.shopwebserver.dto.SimpleProductPublicData(
                            p.id, p.name,  Min(ps.skuPrice),  COALESCE((1-Max(ps.salesOffer.proportion) )*Min(ps.skuPrice),0), p.thumbnailUrl, COALESCE(SUM(r.rate) / COUNT(r.id), 0))
                        FROM Product as p 
                                    JOIN LATERAL (SELECT sku.id as id,sku.skuPrice as skuPrice , sku.salesOffer as salesOffer, sku.skuNo as skuNo FROM ProductSku sku WHERE sku.product.id = p.id ORDER BY sku.skuPrice ASC limit 1) AS ps
                        Left JOIN LATERAL (SELECT op.id as id, op.value as value, op.spuSpecs as spuSpecs FROM SpecsOption op
                                JOIN SpuSpecs sps ON sps.id = op.spuSpecs.id join sps.products pps  WHERE pps.id = p.id GROUP BY op.id) AS spsop
                        LEFT JOIN Review  r on r.product.id = p.id
                        WHERE p.status = :availableStatus\s
                    AND (LOWER(p.name) LIKE   '%' || :keyword || '%' \s
                    OR LOWER(p.description) LIKE  '%' || :keyword || '%')
                    """);



        // Handle filtering by categoryIds
        String categoryIds = filterCriteria.get("categoryIds");
        filterCriteria.remove("categoryIds");
        if (categoryIds != null) {
            jpql.append(" AND p.category.id IN :categoryIds ");
        }
        var startPrice=filterCriteria.get("startPrice");
        var endPrice=filterCriteria.get("endPrice");
        filterCriteria.remove("endPrice");
        filterCriteria.remove("startPrice");
        if(startPrice!=null && endPrice !=null){
            jpql.append(" AND p.category.id IN :categoryIds ");
        }

        // Handle filtering by attributes
        Set<String> attributeNames = filterCriteria.keySet();
        Collection<String> attributeValueIds = filterCriteria.values();
        if (!attributeNames.isEmpty()) {
            jpql.append(" AND spsop.spuSpecs.name IN :attributeNames AND spsop.id IN :attributeValueIds ");
        }


        jpql.append(" GROUP BY p.id ");
        log.info(jpql.toString());
        TypedQuery<SimpleProductPublicData> query = entityManager.createQuery(jpql.toString(), SimpleProductPublicData.class);
        setParameter(query, categoryIds, attributeValueIds, attributeNames, keyword);

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<SimpleProductPublicData> resultList = query.getResultList();
        long total =0;

        try {
            String countJpql = "SELECT COUNT(p.id) " + jpql.substring(jpql.indexOf("FROM"));
            TypedQuery<Long> countQuery = entityManager.createQuery(countJpql, Long.class);
            setParameter(countQuery, categoryIds, attributeValueIds, attributeNames, keyword);
            total = countQuery.getSingleResult();
        }catch (Exception ex){
            log.error(ex.getMessage());
        }

        return new PageImpl<>(resultList, pageable, total);

    }

    private void setParameter(TypedQuery<?> query, String categoryIds, Collection<String> attributeValueIds, Set<String> attributeNames, String keyword) {
        if (categoryIds != null && !categoryIds.isBlank()) {
            query.setParameter("categoryIds", Arrays.asList(categoryIds.split(" ")));
        }
        if (!attributeNames.isEmpty()) {
            query.setParameter("attributeValueIds", attributeValueIds);
            query.setParameter("attributeNames", attributeNames);
        }
        query.setParameter("availableStatus", ProductStatus.available);
        query.setParameter("keyword", keyword.toLowerCase());


    }


}
