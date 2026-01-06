package com.retail.catalog.api.controllers;

import com.retail.catalog.application.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/catalog/products")
public interface ProductController {
    @GetMapping("")
    ResponseEntity<List<Product>> getAll();

    @GetMapping(value = "", params = "categoryId")
    ResponseEntity<List<Product>> getProductsByCategory(@RequestParam Integer categoryId);

    @GetMapping("/{productId}")
    ResponseEntity<?> get(@PathVariable int productId);

    @PostMapping("/productbyids")
    ResponseEntity<List<Product>> getByIds(@RequestBody List<Integer> productIds);

    @PostMapping("/add")
    ResponseEntity<Product> add(@RequestBody Product product);

    @PatchMapping("/update")
    ResponseEntity<Product> update(@RequestBody Product product);

    @DeleteMapping("/delete/{productId}")
    void  delete(@PathVariable int product_id);

}
