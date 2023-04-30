package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService custserv;
	
	public CustomerController() {
		System.out.println("In Home Controller " + getClass());
	}
	//Task 1 = Get Customer information over an REST API call
	@GetMapping( "/") 
    public List<Customer> searchCustomers(@RequestParam (required = false) String firstName,
                                   @RequestParam(required = false) String lastName,
                                   @RequestParam(required = false) String mobile) {
        
        List<Customer> customers = custserv.getCustomersByCriteria(firstName, lastName, mobile);
        
        return customers;
    }

	
	//Task 2 = Ability to create a new customer over REST API.
	  @PostMapping("/register") public String saveEmployee(@RequestBody Customer e)
	  { System.out.println(e); String s1 = custserv.addCustDetails(e); return s1; }
	 
	 
	
	//Task 5 = Ability to delete over REST API
	@DeleteMapping("/delete/{mobile}")
	public String deleteCustomer(@PathVariable String mobile) {
		String d2 = custserv.deleteCustomer(mobile);
		return d2;

	}
	
}
