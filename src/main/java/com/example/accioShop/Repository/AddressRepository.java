package com.example.accioShop.Repository;

import com.example.accioShop.enums.Gender;
import com.example.accioShop.model.Address;
import com.example.accioShop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {


}
