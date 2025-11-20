
package com.retail.catalogservice.application.services;

import com.retail.catalogservice.infrastructure.repositories.domain.Product;
import com.retail.catalogservice.application.model.ProductDTO;

import java.util.List;

public interface ProductAppService {
    List<ProductDTO> getAll();
    ProductDTO getById(int id);
    List<ProductDTO> getByIds(List<Integer> ids);
    ProductDTO add(Product product);
    ProductDTO update(Product product);
    void delete(int id);
}
