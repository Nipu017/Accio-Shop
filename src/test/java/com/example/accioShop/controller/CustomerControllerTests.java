package com.example.accioShop.controller;

import com.example.accioShop.dto.request.CustomerRequest;
import com.example.accioShop.dto.response.CustomerResponse;
import com.example.accioShop.enums.Gender;
import com.example.accioShop.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateCustomer_whenValidRequest() throws Exception {

        CustomerRequest customerRequest = CustomerRequest.builder()
                .name("test-user")
                .age(22)
                .email("user@gmail.com")
                .gender(Gender.FEMALE)
                .mobNo("0000000000")
                .build();

        CustomerResponse customerResponse = CustomerResponse.builder()
                .name("test-user")
                .email("user@gmail.com")
                .createdAt(new Date(2002, 12, 17))
                .build();

        when(customerService.addCustomer(any(CustomerRequest.class)))
                .thenReturn(customerResponse);

        mockMvc.perform(post("/api/v1/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("test-user"))
                .andExpect(jsonPath("$.email").value("user@gmail.com"));

    }
}
