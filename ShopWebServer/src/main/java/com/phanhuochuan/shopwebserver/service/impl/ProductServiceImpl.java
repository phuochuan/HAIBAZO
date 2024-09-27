package com.phanhuochuan.shopwebserver.service.impl;

import com.phanhuochuan.shopwebserver.config.BadRequestException;
import com.phanhuochuan.shopwebserver.config.ServerErrorException;
import com.phanhuochuan.shopwebserver.db.dao.ProductDao;
import com.phanhuochuan.shopwebserver.db.repo.ProductRepository;
import com.phanhuochuan.shopwebserver.dto.PriceSpacePublicData;
import com.phanhuochuan.shopwebserver.dto.ProductDetailPublicData;
import com.phanhuochuan.shopwebserver.dto.SimpleProductPublicData;
import com.phanhuochuan.shopwebserver.mapper.ProductMapper;
import com.phanhuochuan.shopwebserver.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final ProductRepository productRepository;
    @Override
    public Page<SimpleProductPublicData> getAllProducts(Pageable pageable, Map<String, String> filterCriteria) {
        try {

            return productDao.findAllByFilterCriteria(pageable, filterCriteria);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException(e.getMessage());
        }

    }

    @Override
    public PriceSpacePublicData getPriceSpace() {
        return productRepository.findPriceSpace();
    }

    @Override
    public ProductDetailPublicData getProductDetails(Long id) {
        var product =productRepository.findById(id).orElseThrow(()->new BadRequestException("Not found the product details."));
        return ProductMapper.INSTANCE.mapProductDetailPublicData(product);
    }
}
