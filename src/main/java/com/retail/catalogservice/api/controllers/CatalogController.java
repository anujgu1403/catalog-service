
package com.retail.catalogservice.api.controllers;

import com.retail.catalogservice.application.model.ProductDTO;
import com.retail.catalogservice.application.services.ProductAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final ProductAppService productAppService;

    public CatalogController(ProductAppService productAppService) {
        this.productAppService = productAppService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(productAppService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        try {
            return ResponseEntity.ok(productAppService.getById(id));
        } catch(Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping("/getByIds")
    public ResponseEntity<List<ProductDTO>> getByIds(@RequestBody List<Integer> ids) {
        return ResponseEntity.ok(productAppService.getByIds(ids));
    }
}
