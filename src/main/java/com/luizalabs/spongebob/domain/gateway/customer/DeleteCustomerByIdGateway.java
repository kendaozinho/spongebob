package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCustomerByIdGateway {
  void deleteOneById(UUID id) throws NotFoundException, InternalServerErrorException;
}
