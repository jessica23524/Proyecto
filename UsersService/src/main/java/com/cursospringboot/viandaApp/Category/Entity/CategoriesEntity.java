package com.cursospringboot.viandaApp.Category.Entity;


import com.cursospringboot.viandaApp.Menu.Entity.Menu;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name  = "categorias")
public class CategoriesEntity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Long categoriaId;
    private String nombre;
    private String imagen;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Menu> menus;

}
