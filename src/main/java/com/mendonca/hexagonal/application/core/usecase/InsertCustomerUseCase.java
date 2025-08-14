package com.mendonca.hexagonal.application.core.usecase;
import com.mendonca.hexagonal.application.core.domain.*;
import com.mendonca.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.mendonca.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;


    public InsertCustomerUseCase(InsertCustomerOutputPort insertCustomerOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }


    public void insert(Customer customer, String zipCode){

        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);

    }

}

