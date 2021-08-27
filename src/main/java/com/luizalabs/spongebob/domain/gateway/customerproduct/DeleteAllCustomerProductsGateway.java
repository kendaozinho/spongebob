package com.luizalabs.spongebob.domain.gateway.customerproduct;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

public interface DeleteAllCustomerProductsGateway {
  void deleteAll() throws InternalServerErrorException;
}
