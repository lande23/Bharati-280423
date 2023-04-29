package com.avisys.cim;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long>{

	Optional<Customer> findByMobileNumber(String mobileNumber);

}
