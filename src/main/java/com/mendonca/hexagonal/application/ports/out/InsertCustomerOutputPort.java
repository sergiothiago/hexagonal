package com.mendonca.hexagonal.application.ports.out;
import com.mendonca.hexagonal.application.core.domain.*;


public interface InsertCustomerOutputPort {

    void insert(Customer customer);

}
