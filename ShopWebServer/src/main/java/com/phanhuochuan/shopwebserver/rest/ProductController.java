package com.phanhuochuan.shopwebserver.rest;

import com.phanhuochuan.shopwebserver.dto.PriceSpacePublicData;
import com.phanhuochuan.shopwebserver.dto.ProductDetailPublicData;
import com.phanhuochuan.shopwebserver.dto.SimpleProductPublicData;
import com.phanhuochuan.shopwebserver.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    @GetMapping("")
    public Page<SimpleProductPublicData> getAllProducts(@RequestParam(name = "page") int page,
                                                        @RequestParam(name = "limit",defaultValue = "12") int limit,
                                                        @RequestParam Map<String, String> filterCriteria
                                                        ) {
        Pageable pageable = PageRequest.of(page, limit);
        filterCriteria.remove("page");
        filterCriteria.remove("limit");
        return productService.getAllProducts(pageable, filterCriteria);

    }

    @GetMapping("/price-spaces")
    public PriceSpacePublicData priceSpacePublicData(){
        return productService.getPriceSpace();
    }

    @GetMapping("/{id}")
    public ProductDetailPublicData getProductDetails(@PathVariable("id") long id) {
        return productService.getProductDetails(id);
    }
}
