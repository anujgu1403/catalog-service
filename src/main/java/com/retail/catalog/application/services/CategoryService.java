package com.retail.catalog.application.services;

import com.retail.catalog.domain.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> getAll();
    CategoryModel getById(Integer id);
    CategoryModel add(CategoryModel categoryModel);
    CategoryModel update(CategoryModel categoryModel);
    void delete(Integer id);
}