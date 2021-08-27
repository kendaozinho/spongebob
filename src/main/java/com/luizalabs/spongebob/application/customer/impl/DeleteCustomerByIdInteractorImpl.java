package com.luizalabs.spongebob.application.customer.impl;

import com.luizalabs.spongebob.domain.exception.NotFoundException;
import com.luizalabs.spongebob.domain.gateway.customer.DeleteCustomerByIdGateway;
import com.luizalabs.spongebob.domain.gateway.customerproduct.DeleteCustomerProductByIdGateway;
import com.luizalabs.spongebob.domain.gateway.customerproduct.GetCustomerProductsByCustomerIdGateway;
import com.luizalabs.spongebob.domain.interactor.customer.DeleteCustomerByIdInteractor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class DeleteCustomerByIdInteractorImpl implements DeleteCustomerByIdInteractor {
  private final DeleteCustomerByIdGateway deleteCustomerByIdGateway;
  private final GetCustomerProductsByCustomerIdGateway getCustomerProductsByCustomerIdGateway;
  private final DeleteCustomerProductByIdGateway deleteCustomerProductByIdGateway;

  public DeleteCustomerByIdInteractorImpl(
      DeleteCustomerByIdGateway deleteCustomerByIdGateway,
      GetCustomerProductsByCustomerIdGateway getCustomerProductsByCustomerIdGateway,
      DeleteCustomerProductByIdGateway deleteCustomerProductByIdGateway
  ) {
    this.deleteCustomerByIdGateway = deleteCustomerByIdGateway;
    this.getCustomerProductsByCustomerIdGateway = getCustomerProductsByCustomerIdGateway;
    this.deleteCustomerProductByIdGateway = deleteCustomerProductByIdGateway;
  }

  @Override
  @Transactional
  public void execute(UUID id) {
    try {
      this.getCustomerProductsByCustomerIdGateway.getAllByCustomerId(id).forEach(customerProduct ->
          this.deleteCustomerProductByIdGateway.deleteOneById(customerProduct.getCustomerId(), customerProduct.getProductId())
      );
    } catch (NotFoundException exception) {
      // Ignore this exception
    }

    this.deleteCustomerByIdGateway.deleteOneById(id);
  }
}
