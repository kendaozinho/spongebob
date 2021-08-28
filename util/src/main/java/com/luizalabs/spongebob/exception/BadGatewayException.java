package com.luizalabs.spongebob.exception;

public class BadGatewayException extends RuntimeException {
    public BadGatewayException(String details) {
        super(details);
    }
}