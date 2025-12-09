package com.example.accioShop.service;

import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void WhenCustomerIdExists_ThenReturnSavedCustomer()
    {
//        Arrange
        Customer customer = Customer.builder()
                .id(1)
                .name("user-name")
                .age(22)
                .email("user@gmail.com")
                .mobNo("1111111111")
                .gender(Gender.FEMALE)
                .createdAt(new Date(2002,12,17))
                .build();

        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(customer));

//      Act
        CustomerResponse customerResponse = customerService.getCustomerById(1);

//        Assert
        Assertions.assertEquals("user-name",customerResponse.getName());
        Assertions.assertEquals("user@gmail.com",customerResponse.getEmail());
        Assertions.assertNotNull(customerResponse.getCreatedAt());

    }
}
