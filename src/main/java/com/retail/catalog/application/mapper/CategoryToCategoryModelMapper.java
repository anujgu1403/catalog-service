package com.retail.catalog.application.mapper;

import com.retail.catalog.application.model.Category;
import com.retail.catalog.domain.CategoryModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryToCategoryModelMapper implements Function<Category, CategoryModel> {
    @Override
    public CategoryModel apply(Category dto) {
        if (dto == null) return null;
        return new CategoryModel(dto.getCategoryId(), dto.getName());
    }
}