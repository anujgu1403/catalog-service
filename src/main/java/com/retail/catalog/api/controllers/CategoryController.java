package com.retail.catalog.api.controllers;

import com.retail.catalog.application.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/catalog/categories")
public interface CategoryController {

    @GetMapping("")
    ResponseEntity<List<Category>> getAllCategories();

//    @GetMapping("/{categoryId}")
//    ResponseEntity<Category> getCategory(@PathVariable Integer categoryId);
//
//    @PostMapping("/add")
//    ResponseEntity<Category> addCategory(@RequestBody Category category);
//
//    @PatchMapping("/update")
//    ResponseEntity<Category> updateCategory(@RequestBody Category category);
//
//    @DeleteMapping("/delete/{categoryId}")
//    void deleteCategory(@PathVariable Integer categoryId);
}