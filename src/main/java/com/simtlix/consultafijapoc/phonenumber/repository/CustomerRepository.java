package com.simtlix.consultafijapoc.phonenumber.repository;

import com.simtlix.consultafijapoc.phonenumber.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByAccountId(Long accountId);
}