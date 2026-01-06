package com.retail.catalog.api.controllers.impl;

import com.retail.catalog.api.controllers.CategoryController;
import com.retail.catalog.application.mapper.CategoryModelToCategoryMapper;
import com.retail.catalog.application.mapper.CategoryToCategoryModelMapper;
import com.retail.catalog.application.model.Category;
import com.retail.catalog.domain.CategoryModel;
import com.retail.catalog.application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryModelToCategoryMapper modelToDtoMapper;

    @Autowired
    private CategoryToCategoryModelMapper dtoToModelMapper;

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAll()
                .stream()
                .map(modelToDtoMapper::apply)
                .toList();

        return ResponseEntity.ok(categories);
    }
}