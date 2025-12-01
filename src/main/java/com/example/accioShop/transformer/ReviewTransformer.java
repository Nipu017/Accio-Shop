package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.ReviewRequest;
import com.example.accioShop.dto.response.ReviewResponse;
import com.example.accioShop.model.Review;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReviewTransformer {

    public static Review ReviewRequestToReview(ReviewRequest reviewRequest)
    {
        return Review.builder()
                .comment(reviewRequest.getComment())
                .rating(reviewRequest.getRating())
                .build();
    }

    public static ReviewResponse ReviewToReviewResponse(Review review)
    {
        return ReviewResponse.builder()
                .comment(review.getComment())
                .rating(review.getRating())
                .product(ProductTransformer.ProductToProductResponse(review.getProduct()))
                .build();
    }
}
