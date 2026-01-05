package com.retail.catalog.infrastructure.mapper;

import com.retail.catalog.domain.CategoryModel;
import com.retail.catalog.infrastructure.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryModelToCategoryEntityMapper implements Function<CategoryModel, CategoryEntity> {
    @Override
    public CategoryEntity apply(CategoryModel model) {
        if (model == null) return null;
        return new CategoryEntity(model.getCategoryId(), model.getName());
    }
}