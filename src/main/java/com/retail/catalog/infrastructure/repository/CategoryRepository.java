package com.retail.catalog.infrastructure.repository;
import com.retail.catalog.domain.CategoryModel;

import java.util.List;

public interface CategoryRepository {
    List<CategoryModel> getAll();
    CategoryModel getById(Integer id);
    CategoryModel add(CategoryModel categoryModel);
    CategoryModel update(CategoryModel categoryModel);
    void delete(Integer id);
}