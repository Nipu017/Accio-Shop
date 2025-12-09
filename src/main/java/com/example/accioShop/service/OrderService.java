package com.example.accioShop.service;

import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.Repository.OrderRepository;
import com.example.accioShop.dto.request.OrderRequest;
import com.example.accioShop.dto.response.OrderResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.model.OrderEntity;
import com.example.accioShop.transformer.OrderTransformer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    public OrderResponse placeAnOrder(int customerId, OrderRequest orderRequest) {

        Optional<Customer>optionalCustomer = customerRepository.findById(customerId);

        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid CustomerId");
        }

        Customer customer = optionalCustomer.get();
        OrderEntity orderEntity = OrderTransformer.OrderRequestToOrder(orderRequest);

//        relationshit
        orderEntity.setCustomer(customer);
        customer.getOrders().add(orderEntity);

        customerRepository.save(customer);

        return OrderTransformer.OrderToOrderResponse(orderEntity);
    }
}
