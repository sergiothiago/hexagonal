package com.mendonca.hexagonal.adapters.out.client;

import com.mendonca.hexagonal.adapters.out.client.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "findAddressByZipCodeClient",
        url = "${mendonca.client.address.url}"
)
public interface FindAdressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable String zipCode);

}
