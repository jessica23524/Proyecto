package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.CategoriesEntity;

import java.util.List;

public interface ICategoriesServices {
    List<CategoriesEntity> getAllCategories();

}
