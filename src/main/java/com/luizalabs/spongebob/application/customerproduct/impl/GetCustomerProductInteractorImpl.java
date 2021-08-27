package com.luizalabs.spongebob.application.customerproduct.impl;

import com.luizalabs.spongebob.domain.entity.CustomerProduct;
import com.luizalabs.spongebob.domain.gateway.customerproduct.GetCustomerProductByIdGateway;
import com.luizalabs.spongebob.domain.interactor.customerproduct.GetCustomerProductInteractor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetCustomerProductInteractorImpl implements GetCustomerProductInteractor {
    private final GetCustomerProductByIdGateway getCustomerProductByIdGateway;

    public GetCustomerProductInteractorImpl(GetCustomerProductByIdGateway getCustomerProductByIdGateway) {
        this.getCustomerProductByIdGateway = getCustomerProductByIdGateway;
    }

    @Override
    public CustomerProduct execute(UUID customerId, UUID productId) {
        return this.getCustomerProductByIdGateway.getOneById(customerId, productId);
    }
}
