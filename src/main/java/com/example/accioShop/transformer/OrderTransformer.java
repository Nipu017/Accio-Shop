package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.OrderRequest;
import com.example.accioShop.dto.response.OrderResponse;
import com.example.accioShop.model.OrderEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderTransformer {

    public static OrderEntity OrderRequestToOrder(OrderRequest orderRequest)
    {
        return OrderEntity.builder()
                .value(orderRequest.getValue())
                .status(orderRequest.getStatus())
                .build();
    }

    public static OrderResponse OrderToOrderResponse(OrderEntity orderEntity)
    {
        return OrderResponse.builder()
                .value(orderEntity.getValue())
                .status(orderEntity.getStatus())
                .customer(CustomerTransformer.CustomerToCustomerResponse(orderEntity.getCustomer()))
                .build();
    }
}
