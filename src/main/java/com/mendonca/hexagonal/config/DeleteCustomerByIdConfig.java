package com.mendonca.hexagonal.config;

import com.mendonca.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.mendonca.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.mendonca.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.mendonca.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.mendonca.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.mendonca.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                           DeleteCustomerByIdAdapter deleteCustomerByIdAdapter){
        return new DeleteCustomerByIdUseCase( findCustomerByIdUseCase,deleteCustomerByIdAdapter );
    }

}
