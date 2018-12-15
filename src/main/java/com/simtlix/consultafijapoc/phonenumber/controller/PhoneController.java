package com.simtlix.consultafijapoc.phonenumber.controller;

import com.simtlix.consultafijapoc.phonenumber.model.Customer;
import com.simtlix.consultafijapoc.phonenumber.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phone")
@Secured("ROLE_USER")
public class PhoneController {

    private Logger logger = LoggerFactory.getLogger(PhoneController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/{phoneNumber}")
    public Customer getCustomerByPhoneNumber(@PathVariable(value = "phoneNumber", required = true) Long phoneNumber) {
        logger.info("Method 'getCustomerByPhoneNumber' was called for Phone N°: " + phoneNumber);
        return customerService.findByPhoneNumber(phoneNumber);
    }
}
