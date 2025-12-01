package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @NotNull
    private int age;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(length = 10)
    private String mobNo;

//    for bidirectional relationship
//    @OneToOne(mappedBy = "customer")
//    Address address;

    @CreationTimestamp
    Date createdAt;

    @OneToMany
    @JsonBackReference
    List<Review> reviews = new ArrayList<>();

    @OneToMany
    @JsonIgnore
    List<OrderEntity>orders = new ArrayList<>();
}
