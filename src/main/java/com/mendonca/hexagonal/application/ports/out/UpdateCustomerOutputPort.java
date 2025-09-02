package com.mendonca.hexagonal.application.ports.out;

import com.mendonca.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
