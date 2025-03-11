package com.cursospringboot.usersservice.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "usuarios")
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UsersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "contrasenia", nullable = false)
    private String contrasenia;

    @Enumerated(EnumType.STRING) // Mapea el enum como una cadena en la base de datos
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario; // Usar el enum TipoUsuario

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Especifica que es una fecha y hora
    private Date fechaRegistro;

    @Column(name = "direccion")
    private String direccion;
}

// Definir el enum TipoUsuario fuera de la entidad
enum TipoUsuario {
    CLIENTE,
    ADMINISTRADOR
}