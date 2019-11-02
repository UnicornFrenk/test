package com.github.hib.dao.converters;

import com.github.hib.entity.CategoryEntity;
import com.github.hib.entity.ItemEntity;
import com.github.model.Category;
import com.github.model.Item;

public class CategoryConverter {
    public static CategoryEntity toEntity(Category category) {
        if (category == null) {
            return null;
        }
        final CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setIdCategory(category.getIdCategory());
        categoryEntity.setNameCategory(category.getNameCategory());

        return categoryEntity;
    }

    public static Category fromEntity(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        return new Category(categoryEntity.getIdCategory(), categoryEntity.getNameCategory());

    }
}
