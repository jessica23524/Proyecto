package com.cursospringboot.usersservice.Controller;


import com.cursospringboot.usersservice.Entities.MenusEntity;
import com.cursospringboot.usersservice.Services.MenusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenusController {

    @Autowired
    MenusServices menusService;

    @GetMapping("/all")
    public List<MenusEntity> getAllMenus(){
        return menusService.getAllMenus();
    }

    @GetMapping("/{categoryId}")
    public List<MenusEntity> getMenusByCategory(@PathVariable Long categoryId){
        return  menusService.getMenusByCategory(categoryId);
    }
}
