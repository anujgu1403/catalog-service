package com.retail.catalogservice.application.mapper;

import com.retail.catalogservice.application.model.ProductDTO;
import com.retail.catalogservice.infrastructure.repositories.domain.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T09:50:14+0530",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.jar, environment: Java 21.0.7 (Microsoft)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId( product.getProduct_id() );
        productDTO.setCategoryId( product.getCategory_id() );
        productDTO.setUnitPrice( product.getUnit_price() );
        productDTO.setImageUrl( product.getImage_url() );
        productDTO.setCreatedDate( product.getCreated_date() );
        productDTO.setName( product.getName() );
        productDTO.setDescription( product.getDescription() );

        return productDTO;
    }

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setProduct_id( productDTO.getProductId() );
        product.setCategory_id( productDTO.getCategoryId() );
        product.setUnit_price( productDTO.getUnitPrice() );
        product.setImage_url( productDTO.getImageUrl() );
        product.setCreated_date( productDTO.getCreatedDate() );
        product.setName( productDTO.getName() );
        product.setDescription( productDTO.getDescription() );

        return product;
    }
}
