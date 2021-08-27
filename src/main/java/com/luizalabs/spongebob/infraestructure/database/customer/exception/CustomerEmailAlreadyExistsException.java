package com.luizalabs.spongebob.infraestructure.database.customer.exception;

import com.luizalabs.spongebob.domain.exception.ConflictException;

public class CustomerEmailAlreadyExistsException extends ConflictException {
  public CustomerEmailAlreadyExistsException() {
    super("Customer email already exists");
  }
}
