package com.cursospringboot.usersservice.Category.Controller;

import com.cursospringboot.usersservice.Category.Entity.CategoriesEntity;
import com.cursospringboot.usersservice.Category.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<CategoriesEntity> create(@RequestBody CategoriesEntity categorie) {
        CategoriesEntity categotyCreate = categoriesService.create(categorie);
        return  ResponseEntity.status(201).body(categotyCreate);
    }
}
