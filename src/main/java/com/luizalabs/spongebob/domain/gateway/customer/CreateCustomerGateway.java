package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface CreateCustomerGateway {
    Customer create(Customer request) throws ConflictException, InternalServerErrorException;
}
