package com.mendonca.hexagonal.adapters.out;

import com.mendonca.hexagonal.adapters.out.client.mapper.CustomerEntityMapper;
import com.mendonca.hexagonal.adapters.out.repository.CustomerRepository;
import com.mendonca.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mendonca.hexagonal.application.core.domain.Customer;
import com.mendonca.hexagonal.application.ports.out.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerResponseMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity customerEntity = customerResponseMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
