package com.example.accioShop.controller;

import com.example.accioShop.dto.request.SellerRequest;
import com.example.accioShop.dto.response.SellerResponse;
import com.example.accioShop.exception.SellerNotFoundException;
import com.example.accioShop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping
    public ResponseEntity addSeller(@RequestBody SellerRequest sellerRequest)
    {
        SellerResponse response = sellerService.addSeller(sellerRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getSellerById(@RequestParam("id") int id)
    {
        try {
            return new ResponseEntity<>(sellerService.getSellerById(id),HttpStatus.FOUND);
        }
        catch (SellerNotFoundException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
