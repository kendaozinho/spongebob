package com.luizalabs.spongebob.domain.interactor.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;
import java.util.UUID;

public interface GetCustomersByFilterInteractor {
  ArrayList<Customer> execute(UUID id, String name, String email, Integer pageNumber, Integer pageSize)
      throws NotFoundException, InternalServerErrorException;
}
