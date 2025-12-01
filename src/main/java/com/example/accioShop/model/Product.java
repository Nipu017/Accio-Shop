package com.example.accioShop.model;

import com.example.accioShop.enums.Category;
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
public class Product {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    Seller seller;

    @OneToMany(mappedBy = "product")
    List<Review>reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    List<OrderEntity> orders = new ArrayList<>();
}
