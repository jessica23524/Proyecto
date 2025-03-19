package com.cursospringboot.usersservice.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "menus")
public class MenusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id_menu")
    private Long IdMenu;

    @Column(name = "id_categoria")
    private Long idCategoria;

    private String nombre;
    private String descripcion;
    private Double precio;
    private String imagen;
    private boolean disponible;


    @ManyToOne
    @JoinColumn( name = "categoria" ,referencedColumnName = "categoria_id", insertable=false , updatable=false)
    private CategoriesEntity categoria;
}
