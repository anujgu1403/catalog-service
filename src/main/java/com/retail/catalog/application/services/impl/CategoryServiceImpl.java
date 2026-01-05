package com.retail.catalog.application.services.impl;

import com.retail.catalog.domain.CategoryModel;
import com.retail.catalog.infrastructure.repository.CategoryRepository;
import com.retail.catalog.application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryModel> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public CategoryModel getById(Integer id) {
        return categoryRepository.getById(id);
    }

    @Override
    public CategoryModel add(CategoryModel categoryModel) {
        return categoryRepository.add(categoryModel);
    }

    @Override
    public CategoryModel update(CategoryModel categoryModel) {
        return categoryRepository.update(categoryModel);
    }

    @Override
    public void delete(Integer id) {
        categoryRepository.delete(id);
    }
}