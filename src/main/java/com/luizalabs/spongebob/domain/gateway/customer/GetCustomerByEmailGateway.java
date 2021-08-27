package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

public interface GetCustomerByEmailGateway {
  Customer getOneByEmail(String email) throws NotFoundException, InternalServerErrorException;
}
