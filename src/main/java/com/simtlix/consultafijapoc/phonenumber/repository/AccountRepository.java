package com.simtlix.consultafijapoc.phonenumber.repository;


import com.simtlix.consultafijapoc.phonenumber.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Set<Account> findAllByClientId(Integer clientId);
}
