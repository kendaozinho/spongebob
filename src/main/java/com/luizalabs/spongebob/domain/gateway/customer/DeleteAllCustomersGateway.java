package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface DeleteAllCustomersGateway {
    void deleteAll() throws InternalServerErrorException;
}
