package com.luizalabs.spongebob.application.customer.impl;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.gateway.customer.CreateCustomerGateway;
import com.luizalabs.spongebob.domain.interactor.customer.CreateCustomerInteractor;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerInteractorImpl implements CreateCustomerInteractor {
    private final CreateCustomerGateway createCustomerGateway;

    public CreateCustomerInteractorImpl(CreateCustomerGateway createCustomerGateway) {
        this.createCustomerGateway = createCustomerGateway;
    }

    @Override
    public Customer execute(Customer request) {
        return this.createCustomerGateway.create(request);
    }
}
