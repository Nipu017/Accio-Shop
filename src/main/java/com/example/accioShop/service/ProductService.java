package com.example.accioShop.service;

import com.example.accioShop.Repository.ProductRepository;
import com.example.accioShop.Repository.SellerRepository;
import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.response.ProductResponse;
import com.example.accioShop.enums.Category;
import com.example.accioShop.exception.SellerNotFoundException;
import com.example.accioShop.model.Product;
import com.example.accioShop.model.Seller;
import com.example.accioShop.transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    public ProductResponse addProduct(int sellerId, ProductRequest productRequest)
    {
        Optional<Seller>optionalSeller = sellerRepository.findById(sellerId);

        if(optionalSeller.isEmpty())
        {
            throw new SellerNotFoundException("Invalid Seller Id");
        }

        Seller seller = optionalSeller.get();
        Product product = ProductTransformer.ProductRequestToProduct(productRequest);

//        part of relationship

        seller.getProducts().add(product);
        product.setSeller(seller);

        Seller savedEntity = sellerRepository.save(seller);

        int size = savedEntity.getProducts().size();
        Product savedProduct = savedEntity.getProducts().get(size-1);

        return ProductTransformer.ProductToProductResponse(savedProduct);
    }

    public List<ProductResponse> getAllProductOfParticularCategory(Category category) {

        List<Product>products = productRepository.getByCategory(category);
        List<ProductResponse>productResponses = new ArrayList<>();

        for(Product product: products)
        {
            productResponses.add(ProductTransformer.ProductToProductResponse(product));
        }

        return productResponses;
    }
}
