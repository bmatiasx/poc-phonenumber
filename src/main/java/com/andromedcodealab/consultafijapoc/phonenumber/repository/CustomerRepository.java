package com.andromedcodealab.consultafijapoc.phonenumber.repository;

import com.andromedcodealab.consultafijapoc.phonenumber.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByAccountId(Long accountId);
}