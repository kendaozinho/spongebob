package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;

public interface GetAllCustomersGateway {
    ArrayList<Customer> getAll(Integer pageNumber, Integer pageSize) throws NotFoundException, InternalServerErrorException;
}
