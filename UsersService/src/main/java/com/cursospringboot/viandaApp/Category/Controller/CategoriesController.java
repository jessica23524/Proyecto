package com.cursospringboot.viandaApp.Category.Controller;

import com.cursospringboot.viandaApp.Category.Entity.CategoriesEntity;
import com.cursospringboot.viandaApp.Category.Service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PatchMapping("/update/{id}")
    public ResponseEntity<CategoriesEntity> actualizarCategoria(@PathVariable Long id,
                                                         @RequestBody Map<String, Object> camposActualizados) {
        try {
            CategoriesEntity categoriaActualizada = categoriesService.actualizarCategoria(id, camposActualizados);
            return ResponseEntity.ok(categoriaActualizada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
