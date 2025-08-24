package com.mendonca.hexagonal.adapters.out.client.mapper;

import com.mendonca.hexagonal.adapters.out.client.response.AddressResponse;
import com.mendonca.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);


}
