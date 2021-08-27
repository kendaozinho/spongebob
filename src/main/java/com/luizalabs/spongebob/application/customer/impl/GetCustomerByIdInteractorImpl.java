package com.luizalabs.spongebob.application.customer.impl;

import com.luizalabs.spongebob.domain.entity.Customer;
import com.luizalabs.spongebob.domain.entity.CustomerProduct;
import com.luizalabs.spongebob.domain.exception.NotFoundException;
import com.luizalabs.spongebob.domain.gateway.customer.GetCustomerByIdGateway;
import com.luizalabs.spongebob.domain.gateway.customerproduct.DeleteCustomerProductByIdGateway;
import com.luizalabs.spongebob.domain.gateway.customerproduct.GetCustomerProductsByCustomerIdGateway;
import com.luizalabs.spongebob.domain.gateway.product.GetProductByIdGateway;
import com.luizalabs.spongebob.domain.interactor.customer.GetCustomerByIdInteractor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class GetCustomerByIdInteractorImpl implements GetCustomerByIdInteractor {
  private final GetCustomerByIdGateway getCustomerByIdGateway;
  private final GetCustomerProductsByCustomerIdGateway getCustomerProductsByCustomerIdGateway;
  private final GetProductByIdGateway getProductByIdGateway;
  private final DeleteCustomerProductByIdGateway deleteCustomerProductByIdGateway;

  public GetCustomerByIdInteractorImpl(
      GetCustomerByIdGateway getCustomerByIdGateway,
      GetCustomerProductsByCustomerIdGateway getCustomerProductsByCustomerIdGateway,
      GetProductByIdGateway getProductByIdGateway,
      DeleteCustomerProductByIdGateway deleteCustomerProductByIdGateway
  ) {
    this.getCustomerByIdGateway = getCustomerByIdGateway;
    this.getCustomerProductsByCustomerIdGateway = getCustomerProductsByCustomerIdGateway;
    this.getProductByIdGateway = getProductByIdGateway;
    this.deleteCustomerProductByIdGateway = deleteCustomerProductByIdGateway;
  }

  @Override
  @Transactional
  public Customer execute(UUID id, Boolean showProducts) {
    Customer customer = this.getCustomerByIdGateway.getOneById(id);

    if (showProducts) {
      ArrayList<CustomerProduct> customerProducts;

      try {
        customerProducts = this.getCustomerProductsByCustomerIdGateway.getAllByCustomerId(id);
      } catch (NotFoundException exception) {
        customerProducts = new ArrayList<>();
      }

      customer.setProducts(new ArrayList<>());

      customerProducts.forEach(customerProduct -> {
        try {
          customer.getProducts().add(
              this.getProductByIdGateway.getOneById(customerProduct.getProductId())
          );
        } catch (NotFoundException exception) {
          // This product is no longer available
          this.deleteCustomerProductByIdGateway.deleteOneById(customerProduct.getCustomerId(), customerProduct.getProductId());
        }
      });
    }

    return customer;
  }
}
