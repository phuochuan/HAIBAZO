package com.phanhuochuan.shopwebserver.service.impl;

import com.phanhuochuan.shopwebserver.db.repo.CategoryRepository;
import com.phanhuochuan.shopwebserver.dto.CategoryPublicData;
import com.phanhuochuan.shopwebserver.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryPublicData> getAll() {
        return categoryRepository.findCategoryPublicDataAll();
    }
}
