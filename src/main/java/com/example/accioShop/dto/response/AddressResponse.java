package com.example.accioShop.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddressResponse {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;

    private CustomerResponse customer;
}
