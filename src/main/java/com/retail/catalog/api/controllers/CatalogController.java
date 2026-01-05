package com.retail.catalog.api.controllers;

import com.retail.catalog.application.model.Category;
import com.retail.catalog.application.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/catalog")
public interface CatalogController {

    @GetMapping("/products")
    ResponseEntity<List<Product>> getAll();

    @GetMapping(value = "/products", params = "categoryId")
    ResponseEntity<List<Product>> getProductsByCategory(@RequestParam Integer categoryId);

    @GetMapping("/product/{productId}")
    ResponseEntity<?> get(@PathVariable int productId);

    @PostMapping("/productbyids")
    ResponseEntity<List<Product>> getByIds(@RequestBody List<Integer> productIds);

    @PostMapping("/product/add")
    ResponseEntity<Product> add(@RequestBody Product product);

    @PatchMapping("/product/update")
    ResponseEntity<Product> update(@RequestBody Product product);

    @DeleteMapping("/product/delete/{productId}")
    void  delete(@PathVariable int product_id);

    // New Category Endpoints (Added for consistency)
    @GetMapping("/categories")
    ResponseEntity<List<Category>> getAllCategories();

    // Optional: If you want more CRUD for Category via REST
    // @GetMapping("/category/{categoryId}")
    // ResponseEntity<Category> getCategory(@PathVariable Integer categoryId);

    // @PostMapping("/category/add")
    // ResponseEntity<Category> addCategory(@RequestBody Category category);

    // @PatchMapping("/category/update")
    // ResponseEntity<Category> updateCategory(@RequestBody Category category);

    // @DeleteMapping("/category/delete/{categoryId}")
    // void deleteCategory(@PathVariable Integer categoryId);
}
