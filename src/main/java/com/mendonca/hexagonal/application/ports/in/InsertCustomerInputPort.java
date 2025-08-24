package com.mendonca.hexagonal.application.ports.in;

import com.mendonca.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);

}
