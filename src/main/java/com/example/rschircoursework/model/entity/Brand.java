package com.example.rschircoursework.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "brend_type")
@Setter
@Getter
@NoArgsConstructor
public class Brand {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_brend_name")
    private String brandName;

    @Column(name = "sale_in_procent")
    private int sale;
}
