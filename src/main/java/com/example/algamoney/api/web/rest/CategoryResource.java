package com.example.algamoney.api.web.rest;

import com.example.algamoney.api.event.ResourceCreatedEvent;
import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.service.CategoryService;
import com.example.algamoney.api.service.dto.CategoryDTO;
import com.example.algamoney.api.service.mapper.CategoryMapper;
import com.example.algamoney.api.service.mapper.ReleasesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(CategoryResource.URI_CATEGORY)
public class CategoryResource {

    public static final String URI_CATEGORY = "/category";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    ApplicationEventPublisher publisher;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CategoryEntity> list() {

        return categoryService.findAllCategories();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryDTO categoryDTO, HttpServletResponse response) {
        categoryService.saveCategory(categoryMapper.toEntity(categoryDTO));
        publisher.publishEvent(new ResourceCreatedEvent(this, response, categoryDTO.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }

    @RequestMapping(value = "{categoryName}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable(value = "categoryName") String categoryName) {
        categoryService.updateCategory(categoryMapper.toEntity(categoryDTO), categoryName);
        return ResponseEntity.status(HttpStatus.OK).body(categoryDTO);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("name") String name) {
        categoryService.deleteCategory(name);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CategoryEntity findByName(@PathVariable(value = "name") String name) {
        return categoryService.findByName(name);
    }
}
