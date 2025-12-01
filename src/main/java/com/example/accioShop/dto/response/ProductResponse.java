package com.example.accioShop.dto.response;

import com.example.accioShop.enums.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse {

    private String name;

    private int price;

    private Category category;

    private SellerResponse seller;

}
