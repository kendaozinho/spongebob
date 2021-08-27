package com.luizalabs.spongebob.domain.gateway.customerproduct;

import com.luizalabs.spongebob.domain.entity.CustomerProduct;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface CreateCustomerProductGateway {
    CustomerProduct create(CustomerProduct request) throws ConflictException, InternalServerErrorException;
}
