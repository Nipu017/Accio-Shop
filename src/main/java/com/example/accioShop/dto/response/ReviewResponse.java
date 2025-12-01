package com.example.accioShop.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ReviewResponse {

    private String comment;

    private int rating;

    private ProductResponse product;
}
