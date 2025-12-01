package com.example.accioShop.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddressRequest {

    private String houseNo;

    private String city;

    private String state;

    private int pinCode;
}
