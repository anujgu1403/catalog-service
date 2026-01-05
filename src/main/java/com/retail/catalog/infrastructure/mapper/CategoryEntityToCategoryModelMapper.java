package com.retail.catalog.infrastructure.mapper;

import com.retail.catalog.domain.CategoryModel;
import com.retail.catalog.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryEntityToCategoryModelMapper implements Function<CategoryEntity, CategoryModel> {
    @Override
    public CategoryModel apply(CategoryEntity entity) {
        if (entity == null) return null;
        return new CategoryModel(entity.getCategory_id(), entity.getName());
    }
}