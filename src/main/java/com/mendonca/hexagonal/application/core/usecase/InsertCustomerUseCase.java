package com.mendonca.hexagonal.application.core.usecase;
import com.mendonca.hexagonal.application.core.domain.*;
import com.mendonca.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.mendonca.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mendonca.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;


    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }


    @Override
    public void insert(Customer customer, String zipCode){

        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }

}

