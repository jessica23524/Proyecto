package com.cursospringboot.usersservice.Services;

import com.cursospringboot.usersservice.Entities.MenusEntity;

import java.util.List;

public interface IMenuServices {
   List<MenusEntity> getAllMenus();
   List<MenusEntity> getMenusByCategory(Long categoryId);
}
