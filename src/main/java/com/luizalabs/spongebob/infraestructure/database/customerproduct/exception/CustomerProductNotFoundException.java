package com.luizalabs.spongebob.infraestructure.database.customerproduct.exception;

import com.luizalabs.spongebob.domain.exception.NotFoundException;

public class CustomerProductNotFoundException extends NotFoundException {
  public CustomerProductNotFoundException() {
    super("Customer Product(s) not found");
  }
}
