package com.phanhuochuan.shopwebserver.service;

import com.phanhuochuan.shopwebserver.dto.CategoryPublicData;

import java.util.List;

public interface CategoryService {
    List<CategoryPublicData> getAll();
}
