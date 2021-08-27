package com.luizalabs.spongebob.domain.interactor.customer;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCustomerByIdInteractor {
  void execute(UUID id) throws NotFoundException, InternalServerErrorException;
}
