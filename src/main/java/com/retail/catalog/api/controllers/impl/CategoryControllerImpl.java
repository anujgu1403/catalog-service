package com.retail.catalog.api.controllers.impl;

import com.retail.catalog.api.controllers.CategoryController;
import com.retail.catalog.application.mapper.CategoryModelToCategoryMapper;
import com.retail.catalog.application.mapper.CategoryToCategoryModelMapper;
import com.retail.catalog.application.model.Category;
import com.retail.catalog.domain.CategoryModel;
import com.retail.catalog.application.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryModelToCategoryMapper modelToDtoMapper;

    @Autowired
    private CategoryToCategoryModelMapper dtoToModelMapper;

    @Override
    public String list(Model model) {
        List<CategoryModel> models = categoryService.getAll();
        List<Category> dtos = models.stream()
                .map(modelToDtoMapper::apply)
                .toList();
        model.addAttribute("categories", dtos);
        return "categories";
    }

    @Override
    public String addForm(Model model) {
        model.addAttribute("category", new Category());
        return "category-form";
    }

    @Override
    public String add(Category category) {
        CategoryModel model = dtoToModelMapper.apply(category);
        categoryService.add(model);
        return "redirect:/categories";
    }

    @Override
    public String editForm(Integer id, Model model) {
        CategoryModel categoryModel = categoryService.getById(id);
        Category dto = modelToDtoMapper.apply(categoryModel);
        model.addAttribute("category", dto);
        return "category-form";
    }

    @Override
    public String edit(Integer id, Category category) {
        category.setCategoryId(id);
        CategoryModel model = dtoToModelMapper.apply(category);
        categoryService.update(model);
        return "redirect:/categories";
    }

    @Override
    public String delete(Integer id) {
        categoryService.delete(id);
        return "redirect:/categories";
    }
}