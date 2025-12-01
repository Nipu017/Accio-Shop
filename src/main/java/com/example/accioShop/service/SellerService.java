package com.example.accioShop.service;

import com.example.accioShop.Repository.SellerRepository;
import com.example.accioShop.dto.request.SellerRequest;
import com.example.accioShop.dto.response.SellerResponse;
import com.example.accioShop.exception.SellerNotFoundException;
import com.example.accioShop.model.Seller;
import com.example.accioShop.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponse addSeller(SellerRequest sellerRequest) {

        Seller seller = SellerTransformer.SellerRequestToSeller(sellerRequest);
        Seller savedSeller =  sellerRepository.save(seller);
        return SellerTransformer.SellerToSellerResponse(savedSeller);

    }

    public SellerResponse getSellerById(int id) {

        Optional<Seller> optionalSeller = sellerRepository.findById(id);
        if(optionalSeller.isEmpty())
        {
            throw new SellerNotFoundException("Invalid id");
        }

        Seller seller = optionalSeller.get();
        return SellerTransformer.SellerToSellerResponse(seller);
    }
}
