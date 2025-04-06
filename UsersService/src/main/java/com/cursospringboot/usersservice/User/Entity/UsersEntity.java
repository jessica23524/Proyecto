package com.cursospringboot.usersservice.User.Entity;

import com.cursospringboot.usersservice.Order.Entity.OrdersEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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
    private String name;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "contrasenia", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;// Usar el enum TipoUsuario

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // Especifica que es una fecha y hora
    private Date fechaRegistro;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Date(); // Asigna la fecha actual automáticamente
    }
    @Column(name = "direccion")
    private String direccion;


    @OneToMany(mappedBy = "cliente"  , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JsonManagedReference
    private List<OrdersEntity> pedidos;

}

