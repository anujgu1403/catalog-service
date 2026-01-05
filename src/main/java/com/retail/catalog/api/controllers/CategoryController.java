package com.retail.catalog.api.controllers;

import com.retail.catalog.application.model.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public interface CategoryController {

    @GetMapping("/categories")
    String list(Model model);

    @GetMapping("/categories/add")
    String addForm(Model model);

    @PostMapping("/categories/add")
    String add(@ModelAttribute Category category);

    @GetMapping("/categories/edit/{id}")
    String editForm(@PathVariable Integer id, Model model);

    @PostMapping("/categories/edit/{id}")
    String edit(@PathVariable Integer id, @ModelAttribute Category category);

    @GetMapping("/categories/delete/{id}")
    String delete(@PathVariable Integer id);
}