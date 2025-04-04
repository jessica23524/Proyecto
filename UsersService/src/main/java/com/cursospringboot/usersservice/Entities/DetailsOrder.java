package com.cursospringboot.usersservice.Entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor

@Table( name = "detalle_pedidos")
public class DetailsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_pedido")
    private Long detailsOrderId;

    @ManyToOne()
    @JoinColumn(name="pedido_id")
    private OrdersEntity order;

    @ManyToOne()
    @JoinColumn(name = "menu_id")
    private MenusEntity menu;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_unitario")
    private Double priceUnit;

}
