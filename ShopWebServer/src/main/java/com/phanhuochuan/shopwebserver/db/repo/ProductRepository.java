package com.phanhuochuan.shopwebserver.db.repo;

import com.phanhuochuan.shopwebserver.dto.PriceSpacePublicData;
import com.phanhuochuan.shopwebserver.dto.SimpleProductPublicData;
import com.phanhuochuan.shopwebserver.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface  ProductRepository extends JpaRepository<Product,Long> , JpaSpecificationExecutor<Product> {

    @Query("select new  com.phanhuochuan.shopwebserver.dto.PriceSpacePublicData(MAX(pds.skuPrice * (1 - COALESCE(so.proportion, 0.0))), " +
            "MIN(pds.skuPrice * (1 - COALESCE(so.proportion, 0.0)))) " +
            "from ProductSku pds " +
            "left join SalesOffer so on pds.salesOffer.id = so.id")
    PriceSpacePublicData findPriceSpace();
}
