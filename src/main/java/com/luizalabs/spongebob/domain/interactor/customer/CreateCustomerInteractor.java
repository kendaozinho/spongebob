package com.luizalabs.spongebob.domain.interactor.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface CreateCustomerInteractor {
  Customer execute(Customer request) throws ConflictException, InternalServerErrorException;
}
