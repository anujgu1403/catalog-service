package com.retail.catalog.application.mapper;

import com.retail.catalog.application.model.Category;
import com.retail.catalog.domain.CategoryModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class CategoryModelToCategoryMapper implements Function<CategoryModel, Category> {
    @Override
    public Category apply(CategoryModel model) {
        if (model == null) return null;
        return new Category(model.getCategoryId(), model.getName());
    }
}