package com.mendonca.hexagonal.config;

import com.mendonca.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mendonca.hexagonal.adapters.out.InsertCustomerAdapter;
import com.mendonca.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.mendonca.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       InsertCustomerAdapter insertCustomerAdapter,
                                                       SendCpfValidationAdapter sendCpfForValidationAdapter) {
        return new InsertCustomerUseCase(insertCustomerAdapter, findAddressByZipCodeAdapter, sendCpfForValidationAdapter);
    }


}
