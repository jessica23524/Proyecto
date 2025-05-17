package com.cursospringboot.viandaApp.Menu.Controller;


import com.cursospringboot.viandaApp.Menu.Entity.Menu;
import com.cursospringboot.viandaApp.Menu.Service.MenusServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenusServices menusService;

    @GetMapping("/all")
    public List<Menu> getAllMenus(){
        return menusService.getAllMenus();
    }

    @GetMapping("/category/{categoryId}")
    public List<Menu> getMenusByCategory(@PathVariable Long categoryId){
        return  menusService.getMenusByCategory(categoryId);
    }

    @PostMapping("/create")
    public  ResponseEntity<Menu> createMenus(@RequestBody Menu menu){
        Menu menuCreate = menusService.createMenus(menu);
        return ResponseEntity.status(201).body(menuCreate);
    }
}

