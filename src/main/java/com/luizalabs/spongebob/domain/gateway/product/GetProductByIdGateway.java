package com.luizalabs.spongebob.domain.gateway.product;

import com.luizalabs.spongebob.domain.entity.Product;
import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;
import com.luizalabs.spongebob.domain.exception.NotFoundException;

import java.util.UUID;

public interface GetProductByIdGateway {
    Product getOneById(UUID id) throws NotFoundException, InternalServerErrorException;
}
