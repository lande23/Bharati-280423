package com.avisys.cim;

import java.util.List;

public interface CustomerService {

	String addCustDetails(Customer e);

	String deleteCustomer(String mob);
	  List<Customer> getCustomersByCriteria(String firstName, String lastName, String mobile);

}
