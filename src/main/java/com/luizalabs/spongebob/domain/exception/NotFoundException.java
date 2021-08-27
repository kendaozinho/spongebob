package com.luizalabs.spongebob.domain.exception;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String details) {
    super(details);
  }
}