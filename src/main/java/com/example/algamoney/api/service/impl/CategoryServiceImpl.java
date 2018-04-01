package com.example.algamoney.api.service.impl;

import com.example.algamoney.api.Exception.EntityAlreadyExistsException;
import com.example.algamoney.api.Exception.EntityNotFoundException;
import com.example.algamoney.api.Exception.UserException;
import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.repository.CategoryRepository;
import com.example.algamoney.api.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void saveCategory(CategoryEntity categoryEntity) {
        hasConflict(categoryEntity.getName());

        isNotNull(categoryEntity.getName());

        persistCategory(categoryEntity);
    }

    @Override
    public void updateCategory(CategoryEntity categoryEntity, String categoryName) {
        hasConflict(categoryEntity.getName());

        isNotNull(categoryEntity.getName());

        CategoryEntity category = findByName(categoryName);

        category.setName(categoryEntity.getName());

        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String name) {
        CategoryEntity categoryEntity = findByName(name);

        categoryRepository.delete(categoryEntity);
    }

    @Override
    public List<CategoryEntity> findAllCategories() {
        return categoryRepository.findAll();
    }

    private CategoryEntity persistCategory(CategoryEntity categoryEntity) {
        CategoryEntity saveCategory = categoryRepository.save(categoryEntity);
        return saveCategory;
    }

    @Override
    public void hasConflict(String name) {
        if (categoryRepository.findByName(name).isPresent()) {
            throw new EntityAlreadyExistsException(String.format("CategoryEntity with name='%s' already exists", name));
        }
    }

    @Override
    public void isNotNull(String name) {
        if (name.equals("null"))
            throw new UserException(String.format("CategoryEntity with name='%s'", name));
    }


    public CategoryEntity findByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException(String.format("Category not found for name='%s'", name)));
    }
}
