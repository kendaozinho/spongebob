package com.luizalabs.spongebob.domain.interactor.customerproduct;

import com.luizalabs.spongebob.domain.entity.CustomerProduct;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

public interface CreateCustomerProductInteractor {
  CustomerProduct execute(CustomerProduct request) throws NotFoundException, ConflictException, InternalServerErrorException;
}
