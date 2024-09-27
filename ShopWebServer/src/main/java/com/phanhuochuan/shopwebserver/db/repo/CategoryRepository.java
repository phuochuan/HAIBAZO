package com.phanhuochuan.shopwebserver.db.repo;

import com.phanhuochuan.shopwebserver.dto.CategoryPublicData;
import com.phanhuochuan.shopwebserver.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com.phanhuochuan.shopwebserver.dto.CategoryPublicData(c.id,c.name,c.description) from Category  c ")
    List<CategoryPublicData> findCategoryPublicDataAll();
}
