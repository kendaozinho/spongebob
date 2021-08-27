package com.luizalabs.spongebob.infraestructure.api.product.exception;

import com.luizalabs.spongebob.domain.exception.InternalServerErrorException;

import java.util.UUID;

public class UnableToGetProductException extends InternalServerErrorException {
  public UnableToGetProductException(UUID id) {
    super("Unable to get product " + id);
  }
}
