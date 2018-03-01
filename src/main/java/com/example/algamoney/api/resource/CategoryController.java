package com.example.algamoney.api.resource;

import com.example.algamoney.api.event.ResourceCreatedEvent;
import com.example.algamoney.api.model.CategoryEntity;
import com.example.algamoney.api.service.CategoryService;
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
@RequestMapping(CategoryController.URI_CATEGORY)
public class CategoryController {

    public static final String URI_CATEGORY = "/category";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    ApplicationEventPublisher publisher;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CategoryEntity> list() {

        return categoryService.findAllCategories();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CategoryEntity> insert(@Valid @RequestBody CategoryEntity categoryEntity, HttpServletResponse response) {

        categoryService.saveCategory(categoryEntity);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, categoryEntity.getCode()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoryEntity);
    }

    @RequestMapping(value = "{categoryName}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity update(@Valid @RequestBody CategoryEntity categoryEntity, @PathVariable(value = "categoryName") String categoryName) {
        categoryService.updateCategory(categoryEntity, categoryName);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "{name}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("name") String name) {
        categoryService.deleteCategory(name);
        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value ="/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CategoryEntity findByName(@PathVariable (value="name") String name){
        return categoryService.findByName(name);
    }
}
