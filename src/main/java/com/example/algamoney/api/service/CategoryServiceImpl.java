package com.example.algamoney.api.service;

import com.example.algamoney.api.Exception.EntityAlreadyExistsException;
import com.example.algamoney.api.Exception.EntityNotFoundException;
import com.example.algamoney.api.Exception.UserException;
import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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
        log.info("List of categories");
        return categoryRepository.findAll();
    }

    private CategoryEntity persistCategory(CategoryEntity categoryEntity) {
        log.info("Category create success ", categoryEntity.getName());
        CategoryEntity saveCategory = categoryRepository.save(categoryEntity);
        return saveCategory;
    }

    @Override
    public void hasConflict(String name) {
        log.info("CategoryEntity={} message=conflict", name);
        if (categoryRepository.findByName(name).isPresent()) {
            throw new EntityAlreadyExistsException(String.format("CategoryEntity with name='%s' already exists", name));
        }
    }

    @Override
    public void isNotNull(String name) {
        log.info("CategoryEntity is={} message=conflict", name);
        if (name.equals("null"))
            throw new UserException(String.format("CategoryEntity with name='%s'", name));
    }


    public CategoryEntity findByName(String name) {
        log.info("Category by name " + name + " find success");
        return categoryRepository.findByName(name).orElseThrow(() -> new EntityNotFoundException(String.format("Category not found for name='%s'", name)));
    }
}
