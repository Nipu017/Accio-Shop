package com.example.accioShop.Repository;

import com.example.accioShop.enums.Category;
import com.example.accioShop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> getByCategory(Category category);
}
