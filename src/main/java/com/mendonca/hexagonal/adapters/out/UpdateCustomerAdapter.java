package com.mendonca.hexagonal.adapters.out;

import com.mendonca.hexagonal.adapters.out.repository.CustomerRepository;
import com.mendonca.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mendonca.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.mendonca.hexagonal.application.core.domain.Customer;
import com.mendonca.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerResponseMapper;

    @Override
    public void update(Customer customer) {
        CustomerEntity customerEntity = customerResponseMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
