package com.andromedcodealab.consultafijapoc.phonenumber.service;

import com.andromedcodealab.consultafijapoc.phonenumber.model.Account;
import com.andromedcodealab.consultafijapoc.phonenumber.model.Address;
import com.andromedcodealab.consultafijapoc.phonenumber.model.Customer;
import com.andromedcodealab.consultafijapoc.phonenumber.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    public List<Account> findAllByCustomer(Customer customer) {
        List<Address> addresses;
        Set<Account> accounts = accountRepository.findAllByClientId(customer.getClientId());
        List<Account> customerAccounts = new ArrayList<>();

        for (Account account : accounts) {
            Account customerAccount = new Account();
            addresses = addressService.findAllByAccountId(account.getAccountId());

            customerAccount.setAccountId(account.getAccountId());
            customerAccount.setAddresses(addresses);
            customerAccounts.add(customerAccount);
        }

        return customerAccounts;
    }

    /*public Customer findCustomerByAccountId(Long accountId) {

        return customerService.findByAccountId(accountId);
    }*/
}
