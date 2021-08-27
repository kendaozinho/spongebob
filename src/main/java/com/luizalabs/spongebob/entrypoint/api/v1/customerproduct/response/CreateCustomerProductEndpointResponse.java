package com.luizalabs.spongebob.entrypoint.api.v1.customerproduct.response;

import java.util.UUID;

public class CreateCustomerProductEndpointResponse {
    private UUID customerId;
    private UUID productId;

    public CreateCustomerProductEndpointResponse() {
    }

    public CreateCustomerProductEndpointResponse(UUID customerId, UUID productId) {
        this.customerId = customerId;
        this.productId = productId;
    }

    public UUID getCustomerId() {
        return this.customerId;
    }

    public UUID getProductId() {
        return this.productId;
    }
}
