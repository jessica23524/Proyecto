package com.cursospringboot.viandaApp.DetailsOrder.Entity;


import com.cursospringboot.viandaApp.Menu.Entity.Menu;
import com.cursospringboot.viandaApp.Order.Entity.OrdersEntity;
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
    private Menu menu;

    @Column(name = "cantidad")
    private Integer quantity;

    @Column(name = "precio_unitario")
    private Double priceUnit;


}
