package com.example.accioShop.model;

import com.example.accioShop.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class OrderEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int value;

    @Column
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    Customer customer;

    @ManyToMany        //changed
    @JoinTable
    List<Product>products = new ArrayList<>();
}
