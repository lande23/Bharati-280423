package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo crepo;
	
	@Override
	public List<Customer> getAllAccountDetails() {
		
		return this.crepo.findAll();
	}

	@Override
	public String addCustDetails(Customer e) {
		Customer c1 = crepo.findByMobileNumber(e.getMobileNumber()).orElse(null);
		Customer pers;
		if(c1==null) {
		pers = crepo.save(e);
		}
		else {
		throw new ResourceNotFoundException("Unable to create Customer. Mobile number already present.");
			
		}
		return "User Created Successfully"+pers.getFirstName() + " " + pers.getLastName();
	}

}
