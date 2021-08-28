package com.luizalabs.spongebob.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String details) {
        super(details);
    }
}