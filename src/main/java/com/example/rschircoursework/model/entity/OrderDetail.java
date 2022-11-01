package com.example.rschircoursework.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_details")
@Setter
@Getter
@NoArgsConstructor
public class OrderDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", insertable = false, updatable = false)
    @JsonIgnore
    private Order order;

    @Column(name="order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id", insertable = false, updatable = false)
    @JsonIgnore
    private Item item;

    @Column(name="item_id")
    private Long itemId;

    @Column(name = "amount")
    private int amount;
}
