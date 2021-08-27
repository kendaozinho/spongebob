package com.luizalabs.spongebob.infraestructure.api.product.impl;

import com.luizalabs.spongebob.domain.entity.Product;
import com.luizalabs.spongebob.domain.gateway.product.GetProductByIdGateway;
import com.luizalabs.spongebob.infraestructure.api.product.client.ProductApiClient;
import com.luizalabs.spongebob.infraestructure.api.product.exception.ProductNotFoundException;
import com.luizalabs.spongebob.infraestructure.api.product.exception.UnableToGetProductException;
import com.luizalabs.spongebob.infraestructure.api.product.exception.UnexpectedErrorOnGetProductException;
import com.luizalabs.spongebob.infraestructure.api.product.response.ProductApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.UUID;

@Service
public class ProductApiGatewayImpl implements GetProductByIdGateway {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  private final ProductApiClient client;

  public ProductApiGatewayImpl(
      ProductApiClient client
  ) {
    this.client = client;
  }

  @Override
  public Product getOneById(UUID id) throws ProductNotFoundException, UnableToGetProductException, UnexpectedErrorOnGetProductException {
    try {
      HttpEntity<ProductApiResponse> response = this.client.getRestTemplate().getForEntity("/" + id + "/", ProductApiResponse.class);

      this.logger.info("[PRODUCT API] Product " + id + " was obtained with success!");

      return response.getBody().toEntity();
    } catch (HttpStatusCodeException e) {
      String errorMessage = "[PRODUCT API] Unable to get product " + id + "\n" +
          "STATUS: " + e.getStatusCode().value() + " & BODY: " + e.getResponseBodyAsString();

      if (e.getStatusCode().is5xxServerError()) {
        this.logger.error(errorMessage);
      } else {
        this.logger.warn(errorMessage);
      }

      if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
        throw new ProductNotFoundException(id);
      }

      throw new UnableToGetProductException(id);
    } catch (Throwable t) {
      this.logger.error("[PRODUCT API] Unable to get product " + id + ".\nTHROWABLE: " + t);
      throw new UnexpectedErrorOnGetProductException(id, t);
    }
  }
}
