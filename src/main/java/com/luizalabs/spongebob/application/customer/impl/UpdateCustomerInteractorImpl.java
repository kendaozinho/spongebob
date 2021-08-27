package com.luizalabs.spongebob.application.customer.impl;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.gateway.customer.UpdateCustomerGateway;
import com.luizalabs.spongebob.domain.interactor.customer.UpdateCustomerInteractor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCustomerInteractorImpl implements UpdateCustomerInteractor {
  private final UpdateCustomerGateway updateCustomerGateway;

  public UpdateCustomerInteractorImpl(
      UpdateCustomerGateway updateCustomerGateway
  ) {
    this.updateCustomerGateway = updateCustomerGateway;
  }

  @Override
  public Customer execute(UUID id, Customer request) {
    return this.updateCustomerGateway.update(id, request);
  }
}
