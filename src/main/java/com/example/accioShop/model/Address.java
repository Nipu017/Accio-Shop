package com.example.accioShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "address_details")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String houseNo;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private int pinCode;

    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
