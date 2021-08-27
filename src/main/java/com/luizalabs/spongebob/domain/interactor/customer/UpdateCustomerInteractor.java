package com.luizalabs.spongebob.domain.interactor.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.ConflictException;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface UpdateCustomerInteractor {
    Customer execute(UUID id, Customer request) throws NotFoundException, ConflictException, InternalServerErrorException;
}
