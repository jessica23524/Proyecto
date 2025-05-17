package com.cursospringboot.viandaApp.Menu.Service;

import com.cursospringboot.viandaApp.Menu.Entity.Menu;

import java.util.List;

public interface IMenuServices {
   List<Menu> getAllMenus();
   List<Menu> getMenusByCategory(Long categoryId);
   Menu createMenus(Menu menu);
}
