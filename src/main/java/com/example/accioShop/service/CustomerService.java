package com.example.accioShop.service;

import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.CustomerToCustomerResponse(customer);
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
    return CustomerTransformer.CustomerToCustomerResponse(customer);

}

    public List<CustomerResponse> getCustomerByGender(Gender gender) {

//        List<Customer>customers = customerRepository.findAll();
//        List<Customer>customerByGender = new ArrayList<>();
//
//        for(Customer customer: customers)
//        {
//            if(customer.getGender() == gender)
//            {
//                customerByGender.add(customer);
//            }
//        }

        List<Customer>customerByGender = customerRepository.findByGender(gender);

        List<CustomerResponse>customerResponses = new ArrayList<>();

        for(Customer customer: customerByGender)
        {
            customerResponses.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }

        return customerResponses;

    }

    public List<CustomerResponse> getCustomerByAgeGreaterThanEqual(int age) {

        List<Customer>customers = customerRepository.findByAgeGreaterThanEqual(age);
        List<CustomerResponse>customerResponses = new ArrayList<>();

        for(Customer customer: customers)
        {
            customerResponses.add(CustomerTransformer.CustomerToCustomerResponse(customer));
        }

        return customerResponses;
    }
}
