package com.mendonca.hexagonal.adapters.in.consumer;


import com.mendonca.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.mendonca.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.mendonca.hexagonal.application.core.domain.Customer;
import com.mendonca.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "mendonca")
    public void receive(CustomerMessage customerMessage) {

        Customer customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());

    }
}
