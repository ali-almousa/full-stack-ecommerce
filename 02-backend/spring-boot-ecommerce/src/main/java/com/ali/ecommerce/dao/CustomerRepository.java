package com.ali.ecommerce.dao;

import com.ali.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// customer has a collection of orders so when a purchase comes across we will grab the customer
// assemble it accordingly and then save the actual customer using this repo
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
