package com.luizalabs.spongebob.domain.gateway.customer;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;

public interface GetCustomersByNameGateway {
    ArrayList<Customer> getAllByName(String name, Integer pageNumber, Integer pageSize) throws NotFoundException, InternalServerErrorException;
}
