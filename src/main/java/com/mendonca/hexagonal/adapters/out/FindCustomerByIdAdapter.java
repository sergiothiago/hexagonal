package com.mendonca.hexagonal.adapters.out;

import com.mendonca.hexagonal.adapters.out.repository.CustomerRepository;
import com.mendonca.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.mendonca.hexagonal.adapters.out.repository.mapper.CustomerMapper;
import com.mendonca.hexagonal.application.core.domain.Customer;
import com.mendonca.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(entity -> customerMapper.toCustomer(entity) );
    }
}
