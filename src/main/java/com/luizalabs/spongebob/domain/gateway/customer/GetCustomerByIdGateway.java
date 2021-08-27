package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface GetCustomerByIdGateway {
  Customer getOneById(UUID id) throws NotFoundException, InternalServerErrorException;
}
