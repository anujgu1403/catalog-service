package com.retail.catalog.api.controllers.impl;

import com.retail.catalog.api.controllers.CatalogController;
import com.retail.catalog.application.model.Category;
import com.retail.catalog.application.model.Product;
import com.retail.catalog.application.services.CategoryService;
import com.retail.catalog.application.services.ProductService;
import com.retail.catalog.application.mapper.CategoryModelToCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CatalogControllerImpl implements CatalogController {

    @Autowired
    private ProductService productAppService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryModelToCategoryMapper categoryMapper;

    // Existing Product Methods (unchanged)
    @Override
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productAppService.getAll());
    }
    @Override
    public ResponseEntity<List<Product>> getProductsByCategory(Integer categoryId) {
        List<Product> filteredProducts = productAppService.getByCategory(categoryId);
        return ResponseEntity.ok(filteredProducts);
    }

    @Override
    public ResponseEntity<?> get(@PathVariable int productId) {
        try {
            return ResponseEntity.ok(productAppService.getById(productId));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<List<Product>> getByIds(@RequestBody List<Integer> productIds) {
        return ResponseEntity.ok(productAppService.getByIds(productIds));
    }

    @Override
    public ResponseEntity<Product> add(Product product) {
        return ResponseEntity.ok(productAppService.add(product));
    }

    @Override
    public ResponseEntity<Product> update(Product product) {
        return ResponseEntity.ok(productAppService.update(product));
    }

    @Override
    public void delete(int productId) {
        productAppService.delete(productId);
    }

    @Override
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAll()
                .stream()
                .map(categoryMapper::apply)
                .toList();

        return ResponseEntity.ok(categories);
    }
}