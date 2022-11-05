package com.example.rschircoursework.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name="user_id")
    private Long userId;

    // TODO: 05.11.2022 поменять на string; смотреть в проект бд
    @Column(name="order_time")
    private LocalDateTime orderTime;

    @Column(name="cost_order")
    private int costOrder;

    @Transient
    private String inputDate;

}
