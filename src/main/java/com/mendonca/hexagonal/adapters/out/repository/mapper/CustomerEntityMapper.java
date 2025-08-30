package com.mendonca.hexagonal.adapters.out.repository.mapper;

import com.mendonca.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mendonca.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

}
