package com.mendonca.hexagonal.config;

import com.mendonca.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mendonca.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mendonca.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mendonca.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       UpdateCustomerAdapter updateCustomerAdapter){
        return new UpdateCustomerUseCase(findAddressByZipCodeAdapter, findCustomerByIdUseCase,updateCustomerAdapter );
    }

}
