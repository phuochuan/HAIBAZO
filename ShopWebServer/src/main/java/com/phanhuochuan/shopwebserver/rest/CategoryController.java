package com.phanhuochuan.shopwebserver.rest;

import com.phanhuochuan.shopwebserver.dto.CategoryPublicData;
import com.phanhuochuan.shopwebserver.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryPublicData> getCategories() {
        return    categoryService.getAll();
    }
}
