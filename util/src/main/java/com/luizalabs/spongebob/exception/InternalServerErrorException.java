package com.luizalabs.spongebob.exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String details) {
        super(details);
    }
}