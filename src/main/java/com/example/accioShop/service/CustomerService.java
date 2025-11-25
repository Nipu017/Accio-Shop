package com.example.accioShop.service;

import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

//    public Customer addCustomer(Customer customer) {
//        Customer savedCustomer = customerRepository.save(customer);
//        return savedCustomer;
//    }
//    -----------------------------------------------------------------------------
//    In case of DTO
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        Customer customer = CustomerRequestToCustomer(customerRequest);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerToCustomerResponse(customer);
    }

//    public Customer getCustomerById(int id) {
//
//        Optional<Customer> optionalCustomer = customerRepository.findById(id);
//
//        if(optionalCustomer.isEmpty())
//        {
//            throw new CustomerNotFoundException("Invalid Id");
//        }
//
//        Customer customer = optionalCustomer.get();
//        return customer;
//    }
//    DTO---
public CustomerResponse getCustomerById(int id) {

    Optional<Customer> optionalCustomer = customerRepository.findById(id);

    if(optionalCustomer.isEmpty())
    {
        throw new CustomerNotFoundException("Invalid Id");
    }

    Customer customer = optionalCustomer.get();
    return CustomerToCustomerResponse(customer);

}
   public CustomerResponse CustomerToCustomerResponse(Customer customer)
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

   public Customer CustomerRequestToCustomer(CustomerRequest customerRequest)
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
