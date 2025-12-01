package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.model.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerTransformer {

    public static CustomerResponse CustomerToCustomerResponse(Customer customer)
    {
//       CustomerResponse customerResponse = new CustomerResponse();
//       customerResponse.setName(customer.getName());
//       customerResponse.setEmail(customer.getEmail());
//       customerResponse.setCreatedAt(customer.getCreatedAt());
//
//       return customerResponse;

//       we can write all these in this way as well with the help of builder

        return CustomerResponse.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .createdAt(customer.getCreatedAt())
                .build();
    }

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest)
    {
//       Customer customer = new Customer();
//       customer.setName(customerRequest.getName());
//       customer.setAge(customerRequest.getAge());
//       customer.setEmail(customerRequest.getEmail());
//       customer.setGender(customerRequest.getGender());
//       customer.setMobNo(customerRequest.getMobNo());
//
//       return customer;
//        you can write all these in other way as well with the help of builder..

        return Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .email(customerRequest.getEmail())
                .gender(customerRequest.getGender())
                .mobNo(customerRequest.getMobNo())
                .build();
    }
}
