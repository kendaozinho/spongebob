package com.luizalabs.spongebob.domain.gateway.customerproduct;

import com.luizalabs.spongebob.domain.entity.CustomerProduct;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.ArrayList;
import java.util.UUID;

public interface GetCustomerProductsByCustomerIdGateway {
    ArrayList<CustomerProduct> getAllByCustomerId(UUID customerId) throws NotFoundException, InternalServerErrorException;
}
