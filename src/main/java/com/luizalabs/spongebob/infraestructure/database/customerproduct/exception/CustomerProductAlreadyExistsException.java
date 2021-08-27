package com.luizalabs.spongebob.infraestructure.database.customerproduct.exception;

import com.luizalabs.spongebob.domain.exception.ConflictException;

public class CustomerProductAlreadyExistsException extends ConflictException {
    public CustomerProductAlreadyExistsException() {
        super("Customer Product already exists");
    }
}
