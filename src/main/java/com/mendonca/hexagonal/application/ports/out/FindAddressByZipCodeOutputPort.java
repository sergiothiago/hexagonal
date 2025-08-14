package com.mendonca.hexagonal.application.ports.out;

import com.mendonca.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);

}
