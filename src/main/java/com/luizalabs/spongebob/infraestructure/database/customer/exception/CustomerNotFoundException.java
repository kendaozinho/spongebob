package com.luizalabs.spongebob.infraestructure.database.customer.exception;

import com.luizalabs.spongebob.domain.exception.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException() {
        super("Customer(s) not found");
    }
}
