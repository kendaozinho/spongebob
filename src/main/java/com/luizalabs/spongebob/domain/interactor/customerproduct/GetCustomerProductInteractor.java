package com.luizalabs.spongebob.domain.interactor.customerproduct;

import com.luizalabs.spongebob.domain.entity.CustomerProduct;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface GetCustomerProductInteractor {
  CustomerProduct execute(UUID customerId, UUID productId) throws NotFoundException, InternalServerErrorException;
}
