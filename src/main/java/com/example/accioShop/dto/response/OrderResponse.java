package com.example.accioShop.dto.response;

import com.example.accioShop.enums.OrderStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderResponse {

    private int value;

    private OrderStatus status;

    private CustomerResponse customer;
}
