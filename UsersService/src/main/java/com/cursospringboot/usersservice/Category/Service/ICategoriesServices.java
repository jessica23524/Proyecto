package com.cursospringboot.usersservice.Category.Service;

import com.cursospringboot.usersservice.Category.Entity.CategoriesEntity;

import java.util.List;

public interface ICategoriesServices {
    List<CategoriesEntity> getAllCategories();
    CategoriesEntity create (CategoriesEntity categorie);
}
