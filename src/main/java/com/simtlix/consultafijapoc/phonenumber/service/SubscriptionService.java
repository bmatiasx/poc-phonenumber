package com.simtlix.consultafijapoc.phonenumber.service;

import com.simtlix.consultafijapoc.phonenumber.model.Subscription;
import com.simtlix.consultafijapoc.phonenumber.repository.SubscriptionRepository;
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
