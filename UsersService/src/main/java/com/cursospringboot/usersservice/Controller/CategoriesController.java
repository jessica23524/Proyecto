package com.cursospringboot.usersservice.Controller;

import com.cursospringboot.usersservice.Entities.CategoriesEntity;
import com.cursospringboot.usersservice.Services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/all")
    public List<CategoriesEntity> getAll() {
        return categoriesService.getAllCategories();
    }
}
