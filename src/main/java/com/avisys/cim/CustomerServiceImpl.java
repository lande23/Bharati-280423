package com.avisys.cim;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepo crepo;
	
	@Override
	  public List<Customer> getCustomersByCriteria(String firstName, String lastName, String mobile) {
	        List<Customer> l1 = new ArrayList<>();
	        if (firstName != null) {
	            List<Customer> firstNameMatches = crepo.findByFirstNameContainingIgnoreCase(firstName);
	            return firstNameMatches;
	        }
	        
	        else if (lastName != null) {
	            List<Customer> lastNameMatches = crepo.findByLastNameContainingIgnoreCase(lastName);
	            return lastNameMatches;
	        }
	        
	        else if (mobile != null) {
	            Customer cd= crepo.findByMobileNumber(mobile).orElseThrow(null);
	            if(cd !=null) {
	            	l1.add(cd);
	            	return l1;
	            }
	            return null;
	        }
	        
	        return crepo.findAll();
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
		return "User Created Successfully"+" "+pers.getFirstName() + " " + pers.getLastName();
	}

	@Override
	public String deleteCustomer(String mob) {
		Customer ud = crepo.findByMobileNumber(mob).orElseThrow();
		crepo.delete(ud);
		return "Customer deleted sucessfully";
	}
	


}
