package com.luizalabs.spongebob.infraestructure.database.customerproduct.repository;

import com.luizalabs.spongebob.infraestructure.database.customerproduct.table.CustomerProductTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProductTable, CustomerProductTable.CustomerProductTableId> {
  CustomerProductTable findOneByCustomerIdAndProductId(UUID customerId, UUID productId);

  ArrayList<CustomerProductTable> findAllByCustomerId(UUID customerId);
}
