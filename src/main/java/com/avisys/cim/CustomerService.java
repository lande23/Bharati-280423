package com.avisys.cim;

import java.util.List;

public interface CustomerService {

	List<Customer> getAllAccountDetails();

	String addCustDetails(Customer e);

}
