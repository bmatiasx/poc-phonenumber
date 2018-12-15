package com.simtlix.consultafijapoc.phonenumber.repository;

import com.simtlix.consultafijapoc.phonenumber.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findAllByAccountId(Long accountId);
}
