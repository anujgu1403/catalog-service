package com.retail.catalogservice.application.mapper;

import com.retail.catalogservice.application.model.ProductDTO;
import com.retail.catalogservice.infrastructure.repositories.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    // --- Entity → DTO ---
    @Mapping(source = "product_id", target = "productId")
    @Mapping(source = "category_id", target = "categoryId")
    @Mapping(source = "unit_price", target = "unitPrice")
    @Mapping(source = "image_url", target = "imageUrl")
    @Mapping(source = "created_date", target = "createdDate")
    ProductDTO toDto(Product product);


    // --- DTO → Entity ---
    @Mapping(source = "productId", target = "product_id")
    @Mapping(source = "categoryId", target = "category_id")
    @Mapping(source = "unitPrice", target = "unit_price")
    @Mapping(source = "imageUrl", target = "image_url")
    @Mapping(source = "createdDate", target = "created_date")
    Product toEntity(ProductDTO productDTO);
}
