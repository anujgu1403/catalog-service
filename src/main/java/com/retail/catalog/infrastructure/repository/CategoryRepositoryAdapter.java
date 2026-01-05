package com.retail.catalog.infrastructure.repository;

import com.retail.catalog.domain.CategoryModel;
import com.retail.catalog.infrastructure.entity.CategoryEntity;
import com.retail.catalog.infrastructure.mapper.CategoryEntityToCategoryModelMapper;
import com.retail.catalog.infrastructure.mapper.CategoryModelToCategoryEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CategoryRepositoryAdapter implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Autowired
    private CategoryEntityToCategoryModelMapper entityToModelMapper;

    @Autowired
    private CategoryModelToCategoryEntityMapper modelToEntityMapper;

    @Override
    public List<CategoryModel> getAll() {
        return categoryJpaRepository.findAll().stream()
                .map(entityToModelMapper::apply)
                .toList();
    }

    @Override
    public CategoryModel getById(Integer id) {
        CategoryEntity entity = categoryJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return entityToModelMapper.apply(entity);
    }

    @Override
    public CategoryModel add(CategoryModel categoryModel) {
        CategoryEntity entity = modelToEntityMapper.apply(categoryModel);
        entity.setCategory_id(null);
        CategoryEntity saved = categoryJpaRepository.save(entity);
        return entityToModelMapper.apply(saved);
    }

    @Override
    public CategoryModel update(CategoryModel categoryModel) {
        if (categoryModel.getCategoryId() == null) {
            throw new IllegalArgumentException("Category ID required for update");
        }
        CategoryEntity entity = modelToEntityMapper.apply(categoryModel);
        Optional<CategoryEntity> existing = categoryJpaRepository.findById(entity.getCategory_id());
        if (existing.isEmpty()) {
            throw new RuntimeException("Category not found");
        }
        CategoryEntity toSave = existing.get();
        toSave.setName(Optional.ofNullable(entity.getName()).orElse(toSave.getName()));
        CategoryEntity saved = categoryJpaRepository.save(toSave);
        return entityToModelMapper.apply(saved);
    }

    @Override
    public void delete(Integer id) {
        categoryJpaRepository.deleteById(id);
    }
}