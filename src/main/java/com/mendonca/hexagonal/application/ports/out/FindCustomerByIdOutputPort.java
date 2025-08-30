package com.mendonca.hexagonal.application.ports.out;

import com.mendonca.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> find(String id);

}
