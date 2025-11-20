
package com.retail.catalogservice.api.controllers;

import com.retail.catalogservice.application.model.ProductDTO;
import com.retail.catalogservice.application.services.ProductAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductAppService productAppService;

    public ProductController(ProductAppService productAppService) {
        this.productAppService = productAppService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(productAppService.getAll());
    }
}
