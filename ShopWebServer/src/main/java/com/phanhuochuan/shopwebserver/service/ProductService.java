package com.phanhuochuan.shopwebserver.service;

import com.phanhuochuan.shopwebserver.dto.PriceSpacePublicData;
import com.phanhuochuan.shopwebserver.dto.ProductDetailPublicData;
import com.phanhuochuan.shopwebserver.dto.SimpleProductPublicData;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ProductService {
    Page<SimpleProductPublicData> getAllProducts(Pageable pageable, Map<String, String> filterCriteria);

    PriceSpacePublicData getPriceSpace();

    ProductDetailPublicData getProductDetails(Long id) throws BadRequestException;
}
