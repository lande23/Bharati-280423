package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService custserv;
	
	public CustomerController() {
		System.out.println("In Home Controller " + getClass());
	}
	
	@RequestMapping("/")
	public List<Customer> allDetails1() {
		List<Customer> list = custserv.getAllAccountDetails();
		System.out.println(list);
		return list;

	}
	@PostMapping("/register")
	public String saveEmployee(@RequestBody Customer e) {
		System.out.println(e);
		String s1 = custserv.addCustDetails(e);
		return s1;
	}
	
}
