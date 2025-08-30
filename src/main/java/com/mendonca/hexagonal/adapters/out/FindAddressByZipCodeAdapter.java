package com.mendonca.hexagonal.adapters.out;

import com.mendonca.hexagonal.adapters.out.client.FindAdressByZipCodeClient;
import com.mendonca.hexagonal.adapters.out.repository.mapper.AddressResponseMapper;
import com.mendonca.hexagonal.adapters.out.client.response.AddressResponse;
import com.mendonca.hexagonal.application.core.domain.Address;
import com.mendonca.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAdressByZipCodeClient findAdressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {

        AddressResponse addressResponse = findAdressByZipCodeClient.find(zipCode);

        return addressResponseMapper.toAddress(addressResponse);
    }
}
