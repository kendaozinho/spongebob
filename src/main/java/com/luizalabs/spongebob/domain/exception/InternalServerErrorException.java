package com.luizalabs.spongebob.domain.exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String details) {
        super(details);
    }
}