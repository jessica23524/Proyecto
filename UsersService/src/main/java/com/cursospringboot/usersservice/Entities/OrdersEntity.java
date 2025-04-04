package com.cursospringboot.usersservice.Entities;


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

    private enum estado {
        PENDIENTE,
        PREPARANDO,
        ENVIADO,
        ENTREGADO,
        CANCELADO
    }

    private Double total;

    @Column(name = "direccion_envio")
    private String direccion;

    private enum metodoPago{
        EFECTIVO,
        TARJETA,
        PAYPAL
    }

    @Column(name = "fecha_pedido")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id" , nullable = false)
    @JsonIgnore
    private UsersEntity cliente;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<DetailsOrder> detallesPedido = new ArrayList<>();

    public Long getIdCliente() {
        return cliente != null ? cliente.getIdUsuario() : null;
    }

}
