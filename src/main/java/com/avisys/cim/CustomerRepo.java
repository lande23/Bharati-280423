package com.avisys.cim;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

	Optional<Customer> findByMobileNumber(String mobileNumber);

	List<Customer> findByFirstNameContainingIgnoreCase(String firstName);

	List<Customer> findByLastNameContainingIgnoreCase(String lastName);

}
