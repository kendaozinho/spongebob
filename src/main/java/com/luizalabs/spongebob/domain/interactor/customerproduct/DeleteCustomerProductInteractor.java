package com.luizalabs.spongebob.domain.interactor.customerproduct;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface DeleteCustomerProductInteractor {
  void execute(UUID customerId, UUID productId) throws NotFoundException, InternalServerErrorException;
}
