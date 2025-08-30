package com.mendonca.hexagonal.application.core.usecase;


import com.mendonca.hexagonal.application.core.domain.Customer;
import com.mendonca.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

/**
 * Use case for finding a customer by their ID.
 */
public class FindCustomerByIdUseCase {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    /**
     * Finds a customer by their ID.
     *
     * @param id The ID of the customer to find.
     * @return The found customer.
     * @throws RuntimeException if the customer is not found.
     */
    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id).orElseThrow(
                () -> new RuntimeException("Customer not found")
        );
    }

}
