package com.andromedcodealab.consultafijapoc.phonenumber.repository;


import com.andromedcodealab.consultafijapoc.phonenumber.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Set<Account> findAllByClientId(Integer clientId);
}
