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
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private Status state;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private Double total;

    @Column(name = "direccion_envio")
    private String address;


    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @PrePersist

    protected void onCreate() {
        this.date = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private UsersEntity customer;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<DetailsOrder> detallesPedido = new ArrayList<>();

    public Long getIdCliente() {
        return customer != null ? customer.getIdUsuario() : null;
    }

}

