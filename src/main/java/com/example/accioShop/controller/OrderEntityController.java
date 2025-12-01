package com.example.accioShop.controller;

import com.example.accioShop.dto.request.OrderRequest;
import com.example.accioShop.dto.response.OrderResponse;
import com.example.accioShop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderEntityController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity placeAnOrder(@RequestParam("customer-id") int customerId,
                                       @RequestBody OrderRequest orderRequest)
    {
        OrderResponse orderResponse = orderService.placeAnOrder(customerId,orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

}
