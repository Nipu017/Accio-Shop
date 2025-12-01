package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.AddressRequest;
import com.example.accioShop.dto.response.AddressResponse;
import com.example.accioShop.model.Address;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressTransformer {

    public static Address AddressRequestToAddress(AddressRequest addressRequest)
    {
        return Address.builder()
                .houseNo(addressRequest.getHouseNo())
                .city(addressRequest.getCity())
                .state(addressRequest.getState())
                .pinCode(addressRequest.getPinCode())
                .build();
    }

    public static AddressResponse AddressToAddressResponse(Address address)
    {
        return AddressResponse.builder()
                .houseNo(address.getHouseNo())
                .city(address.getCity())
                .state(address.getState())
                .pinCode(address.getPinCode())
                .customer(CustomerTransformer.CustomerToCustomerResponse(address.getCustomer()))  //hehehe
                .build();
    }

}
