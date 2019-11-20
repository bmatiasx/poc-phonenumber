package com.andromedcodealab.consultafijapoc.phonenumber.service;

import com.andromedcodealab.consultafijapoc.phonenumber.model.Subscription;
import com.andromedcodealab.consultafijapoc.phonenumber.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> findAllByAccountId(Long accountId) {

        return subscriptionRepository.findAllByAccountId(accountId);
    }
}
