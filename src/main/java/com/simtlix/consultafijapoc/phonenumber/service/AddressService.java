package com.simtlix.consultafijapoc.phonenumber.service;

import com.simtlix.consultafijapoc.phonenumber.model.Address;
import com.simtlix.consultafijapoc.phonenumber.model.Subscription;
import com.simtlix.consultafijapoc.phonenumber.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    private SubscriptionService subscriptionService;

    public List<Address> findAllByAccountId(Long accountId) {
        List<Subscription> subscriptions;
        Set<Address> addresses = addressRepository.findAllByAccountId(accountId).stream().collect(Collectors.toSet());
        List<Address> customerAdresses = new ArrayList<>();

        for (Address address : addresses) {
            address = replaceNullAddressValues(address);
            subscriptions = subscriptionService.findAllByAccountId(address.getAccountId());
            Set<Subscription> customerSubscriptions = new HashSet<>();

            for (Subscription s : subscriptions) {
                s = replaceNullSubscriptionValues(s);
                if (s.getNumber().equals(address.getNumber()) && s.getDepartment().equals(address.getDepartment())
                        && s.getCity().equals(address.getCity()) && s.getStreet().equals(address.getStreet())) {
                    customerSubscriptions.add(s);
                }
            }
            customerAdresses.add(setCustomerAddress(address, customerSubscriptions));
        }

        return customerAdresses;
    }

    public Address findByPhoneNumber(Long phoneNumber) {
        return addressRepository.findByCellularNumber(phoneNumber);
    }

    private Address setCustomerAddress(Address address, Set<Subscription> subscriptions) {
        Address customerAddress = new Address();
        customerAddress.setAccountId(address.getAccountId());
        customerAddress.setStreet(address.getStreet());
        customerAddress.setNumber(address.getNumber());
        customerAddress.setTower(address.getTower());
        customerAddress.setFloor(address.getFloor());
        customerAddress.setFlat(address.getFlat());
        customerAddress.setWithinStreets(address.getWithinStreets());
        customerAddress.setCity(address.getCity());
        customerAddress.setDepartment(address.getDepartment());
        customerAddress.setSubscriptions(subscriptions);

        return customerAddress;
    }

    private Subscription replaceNullSubscriptionValues(Subscription subscription) {
        Subscription customerSubscription = new Subscription();

        if (subscription.getServiceTypeId() == null) {
            customerSubscription.setServiceTypeId("");
        } else {
            customerSubscription.setServiceTypeId(subscription.getServiceTypeId());
        }

        if (subscription.getServiceTypeDescription() == null) {
            customerSubscription.setServiceTypeDescription("");
        } else {
            customerSubscription.setServiceTypeDescription(subscription.getServiceTypeDescription());
        }

        if (subscription.getPlan() == null) {
            customerSubscription.setPlan("");
        } else {
            customerSubscription.setPlan(subscription.getPlan());
        }

        if (subscription.getCellularNumber() == null) {
            customerSubscription.setCellularNumber(0L);
        } else {
            customerSubscription.setCellularNumber(subscription.getCellularNumber());
        }

        if (subscription.getNumber() == null) {
            customerSubscription.setNumber("");
        } else {
            customerSubscription.setNumber(subscription.getNumber());
        }
        if (subscription.getStreet() == null) {
            customerSubscription.setStreet("");
        } else {
            customerSubscription.setStreet(subscription.getStreet());
        }
        if (subscription.getCity() == null) {
            customerSubscription.setCity("");
        } else {
            customerSubscription.setCity(subscription.getCity());
        }
        if (subscription.getDepartment() == null) {
            customerSubscription.setDepartment("");
        } else {
            customerSubscription.setDepartment(subscription.getDepartment());
        }
        if (subscription.getFlat() == null) {
            customerSubscription.setFlat("");
        } else {
            customerSubscription.setFlat(subscription.getFlat());
        }
        if (subscription.getFloor() == null) {
            customerSubscription.setFloor("");
        } else {
            customerSubscription.setFloor(subscription.getFloor());
        }
        if (subscription.getTower() == null) {
            customerSubscription.setTower("");
        } else {
            customerSubscription.setTower(subscription.getTower());
        }
        if (subscription.getWithinStreets() == null) {
            customerSubscription.setWithinStreets("");
        } else {
            customerSubscription.setWithinStreets(subscription.getWithinStreets());
        }
        if (subscription.getCp() == null) {
            customerSubscription.setCp("");
        } else {
            customerSubscription.setCp(subscription.getCp());
        }

        return customerSubscription;
    }

    private Address replaceNullAddressValues(Address address) {
        Address customerAddress = new Address();

        customerAddress.setAccountId(address.getAccountId());

        if (address.getNumber() == null) {
            customerAddress.setNumber("");
        } else {
            customerAddress.setNumber(address.getNumber());
        }
        if (address.getStreet() == null) {
            customerAddress.setStreet("");
        } else {
            customerAddress.setStreet(address.getStreet());
        }
        if (address.getCity() == null) {
            customerAddress.setCity("");
        } else {
            customerAddress.setCity(address.getCity());
        }
        if (address.getDepartment() == null) {
            customerAddress.setDepartment("");
        } else {
            customerAddress.setDepartment(address.getDepartment());
        }
        if (address.getFlat() == null) {
            customerAddress.setFlat("");
        } else {
            customerAddress.setFlat(address.getFlat());
        }

        if (address.getFloor() == null) {
            customerAddress.setFloor("");
        } else {
            customerAddress.setFloor(address.getFloor());
        }

        if (address.getTower() == null) {
            customerAddress.setTower("");
        } else {
            customerAddress.setTower(address.getTower());
        }

        if (address.getWithinStreets() == null) {
            customerAddress.setWithinStreets("");
        } else {
            customerAddress.setWithinStreets(address.getWithinStreets());
        }

        if (address.getCp() == null) {
            customerAddress.setCp("");
        } else {
            customerAddress.setCp(address.getCp());
        }

        customerAddress.setSubscriptions(address.getSubscriptions());

        return customerAddress;
    }
}
