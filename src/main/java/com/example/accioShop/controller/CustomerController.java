package com.example.accioShop.controller;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    @PostMapping
//    public ResponseEntity addCustomer(@RequestBody Customer customer)
//    {
//        Customer savedCustomer = customerService.addCustomer(customer);
//        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
//    }

//    ------------------------------------------------------------------------------
//    this is for DTO:-
    @PostMapping
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest)
    {
        CustomerResponse customerResponse = customerService.addCustomer(customerRequest);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity getCustomerById(@RequestParam("id") int id)
//    {
//        try {
//            return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.FOUND);
//        }
//        catch (CustomerNotFoundException e)
//        {
//            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
//        }
//    }

//    in DTO
    @GetMapping
    public ResponseEntity getCustomerById(@RequestParam("id") int id)
    {
        try {
            CustomerResponse response = customerService.getCustomerById(id);
            return new ResponseEntity<>(response,HttpStatus.FOUND);
        }
        catch (CustomerNotFoundException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

//    filtering by gender
    @GetMapping("/gender/{gender}")
    public ResponseEntity getCustomerByGender(@PathVariable Gender gender)
    {
        List<CustomerResponse>responses = customerService.getCustomerByGender(gender);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

//    filtering by age limit
    @GetMapping("/age")
    public ResponseEntity getCustomerByAgeGreaterThanEqual(@RequestParam("age") int age)
    {
        List<CustomerResponse> responses = customerService.getCustomerByAgeGreaterThanEqual(age);
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteCustomer(@RequestParam("customer-id") int customerId)
    {
        try {
            CustomerResponse response = customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
