package com.cursospringboot.viandaApp.User.Entity;

import com.cursospringboot.viandaApp.Order.Entity.OrdersEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private UserType userType = UserType.CLIENTE;// Usar el enum TipoUsuario

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDateTime.now();
        }
    }

    @Column(name = "direccion")
    private String address;

    @OneToMany(mappedBy = "customer"  , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    @JsonManagedReference
    private List<OrdersEntity> orders;

}

