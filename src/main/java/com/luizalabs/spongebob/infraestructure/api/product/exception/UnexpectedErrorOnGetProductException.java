package com.luizalabs.spongebob.infraestructure.api.product.exception;

import com.luizalabs.spongebob.domain.exception.BadGatewayException;

import java.util.UUID;

public class UnexpectedErrorOnGetProductException extends BadGatewayException {
  public UnexpectedErrorOnGetProductException(UUID id, Throwable t) {
    super("Unexpected error on get product " + id + ": " + t);
  }
}
