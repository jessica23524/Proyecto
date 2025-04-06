package com.cursospringboot.usersservice.Order.Entity;


import com.cursospringboot.usersservice.DetailsOrder.Entity.DetailsOrder;
import com.cursospringboot.usersservice.User.Entity.UsersEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    private Double total;

    @Column(name = "direccion_envio")
    private String direccion;


    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @PrePersist

    protected void onCreate() {
        this.fecha = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private UsersEntity cliente;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<DetailsOrder> detallesPedido = new ArrayList<>();

    public Long getIdCliente() {
        return cliente != null ? cliente.getIdUsuario() : null;
    }

}

