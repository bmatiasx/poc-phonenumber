package com.andromedcodealab.consultafijapoc.phonenumber.service;

import com.andromedcodealab.consultafijapoc.phonenumber.model.Account;
import com.andromedcodealab.consultafijapoc.phonenumber.model.Address;
import com.andromedcodealab.consultafijapoc.phonenumber.model.Customer;
import com.andromedcodealab.consultafijapoc.phonenumber.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    public Customer findByPhoneNumber(Long phoneNumber) {
        Address address = addressService.findByPhoneNumber(phoneNumber);

        Customer customer = customerRepository.findByAccountId(address.getAccountId());

        List<Account> accounts = accountService.findAllByCustomer(customer);

        customer.setAccounts(accounts);

        return customer;
    }
}
