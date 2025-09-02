package com.mendonca.hexagonal.application.core.usecase;

import com.mendonca.hexagonal.application.core.domain.Address;
import com.mendonca.hexagonal.application.core.domain.Customer;
import com.mendonca.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.mendonca.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.mendonca.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mendonca.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, FindCustomerByIdInputPort findCustomerByIdInputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find((customer.getId()));

        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);

        updateCustomerOutputPort.update(customer);
    }

}
