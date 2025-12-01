package com.example.accioShop.service;

import com.example.accioShop.Repository.CustomerRepository;
import com.example.accioShop.Repository.ProductRepository;
import com.example.accioShop.Repository.ReviewRepository;
import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.request.ReviewRequest;
import com.example.accioShop.dto.response.ReviewResponse;
import com.example.accioShop.exception.CustomerNotFoundException;
import com.example.accioShop.exception.ProductNotFoundException;
import com.example.accioShop.exception.ReviewNotFoundException;
import com.example.accioShop.model.Customer;
import com.example.accioShop.model.Product;
import com.example.accioShop.model.Review;
import com.example.accioShop.transformer.ReviewTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    public ReviewResponse getReviewById(int id) {

        Optional<Review> optionalReview = reviewRepository.findById(id);

        if(optionalReview.isEmpty())
        {
            throw new ReviewNotFoundException("Invalid Id");
        }

        Review review =  optionalReview.get();
        return ReviewTransformer.ReviewToReviewResponse(review);
    }

    public ReviewResponse addReview(int customerId, int productId, ReviewRequest reviewRequest) {

        Optional<Customer>optionalCustomer = customerRepository.findById(customerId);
        Optional<Product>optionalProduct = productRepository.findById(productId);

        if(optionalCustomer.isEmpty())
        {
            throw new CustomerNotFoundException("Invalid Customer Id");
        }

        if(optionalProduct.isEmpty())
        {
            throw new ProductNotFoundException("Invalid Product Id");
        }

        Customer customer = optionalCustomer.get();
        Product product = optionalProduct.get();
        Review review = ReviewTransformer.ReviewRequestToReview(reviewRequest);

//        relationship
        review.setCustomer(customer);
        review.setProduct(product);

        Review savedReview = reviewRepository.save(review);

        return ReviewTransformer.ReviewToReviewResponse(savedReview);

    }
}
