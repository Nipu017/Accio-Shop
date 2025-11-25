package com.example.accioShop.service;

import com.example.accioShop.Repository.ReviewRepository;
import com.example.accioShop.exception.ReviewNotFoundException;
import com.example.accioShop.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    public Review getReviewById(int id) {

        Optional<Review> optionalReview = reviewRepository.findById(id);

        if(optionalReview.isEmpty())
        {
            throw new ReviewNotFoundException("Invalid Id");
        }

        return optionalReview.get();
    }
}
