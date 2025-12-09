package com.example.accioShop.repository;

import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepository;

    @Test
    void shouldSucceed_WhenValidCustomerIsAdded()
    {
//        AAA - Arrange,Act,Assert
        Customer customer = Customer.builder()
                .name("test-user")
                .age(38)
                .email("test@gmail.com")
                .gender(Gender.FEMALE)
                .mobNo("0000000000")
                .build();

        Customer savedCustomer = customerRepository.save(customer);

        Assertions.assertEquals("test-user",savedCustomer.getName());
        Assertions.assertNotEquals(0,savedCustomer.getId());
        Assertions.assertNotNull(savedCustomer.getCreatedAt());
    }

}
