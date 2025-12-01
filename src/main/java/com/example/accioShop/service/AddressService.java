package com.example.accioShop.service;

import com.example.accioShop.Repository.AddressRepository;
import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.dto.request.AddressRequest;
import com.example.accioShop.dto.response.AddressResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.model.Address;
import com.example.accioShop.model.Customer;
import com.example.accioShop.transformer.AddressTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    CustomerRepository customerRepository;

    public AddressResponse addAddress(int customerId, AddressRequest addressRequest) {

        Optional<Customer>optionalCustomer = customerRepository.findById(customerId);

        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid CustomerId");
        }

        Customer customer = optionalCustomer.get();
        Address address = AddressTransformer.AddressRequestToAddress(addressRequest);

//        relationship
        address.setCustomer(customer);

        Address savedAddress = addressRepository.save(address);

        return AddressTransformer.AddressToAddressResponse(savedAddress);
    }
}
