package com.example.accioShop.service;

import com.example.accioShop.Repository.SellerRepository;
import com.example.accioShop.exception.SellerNotFoundById;
import com.example.accioShop.model.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public Seller addSeller(Seller seller) {

        return sellerRepository.save(seller);

    }

    public Seller getSellerById(int id) {

        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if(optionalSeller.isEmpty())
        {
            throw new SellerNotFoundById("Invalid id");
        }

        return optionalSeller.get();
    }
}
