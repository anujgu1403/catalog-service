
package com.retail.catalogservice.application.services.impl;

import com.retail.catalogservice.application.mapper.ProductMapper;
import com.retail.catalogservice.infrastructure.repositories.ProductRepository;
import com.retail.catalogservice.application.services.ProductAppService;
import com.retail.catalogservice.infrastructure.repositories.domain.Product;
import com.retail.catalogservice.application.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductAppServiceImpl implements ProductAppService {

    private final ProductRepository repository;
    @Autowired
    private ProductMapper productMapper;

    public ProductAppServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> getAll() {
        List<Product> products = repository.findAll();
       return products.stream()
               .map(product ->  productMapper.toDto(product)).toList();

    }

    @Override
    public ProductDTO getById(int id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> getByIds(List<Integer> ids) {
        List<Product> products =  repository.findAllById(ids).stream().toList();
        return products.stream()
                .map(product ->  productMapper.toDto(product)).toList();
    }

    @Override
    public ProductDTO add(Product product) {
        // ensure id is null so JPA will insert
        product.setProduct_id(null);
        Product productResp = repository.save(product);
        return productMapper.toDto(productResp);
    }

    @Override
    public ProductDTO update(Product product) {
        if (product.getProduct_id() == null) {
            throw new IllegalArgumentException("Product id must be provided for update");
        }
        Optional<Product> existing = repository.findById(product.getProduct_id());
        if (existing.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        // copy fields (in simple case overwrite)
        var p = existing.get();
        p.setName(product.getName());
        p.setUnit_price(product.getUnit_price());

        Product productResp = repository.save(product);
        return productMapper.toDto(productResp);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
