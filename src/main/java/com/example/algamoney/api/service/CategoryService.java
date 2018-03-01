package com.example.algamoney.api.service;

import com.example.algamoney.api.model.CategoryEntity;

import java.util.List;

public interface CategoryService {

    void saveCategory(CategoryEntity categoryEntity);

    void updateCategory(CategoryEntity categoryEntity, String CategoryName);

    void deleteCategory(String name);

    void hasConflict(String name);

    void isNotNull(String name);

    CategoryEntity findByName(String name);

    List<CategoryEntity> findAllCategories();
}
