package com.simtlix.consultafijapoc.phonenumber.repository;

import com.simtlix.consultafijapoc.phonenumber.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByAccountId(Long accountId);

    Address findByCellularNumber(Long phoneNumber);
}
