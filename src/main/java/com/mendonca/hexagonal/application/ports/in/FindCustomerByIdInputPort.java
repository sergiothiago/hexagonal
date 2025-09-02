package com.mendonca.hexagonal.application.ports.in;

import com.mendonca.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {
    Customer find(String id);
}
