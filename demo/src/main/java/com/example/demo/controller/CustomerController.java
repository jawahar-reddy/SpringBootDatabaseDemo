package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerDB;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.request.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/create")
	public String createCustomer(@RequestBody Customer customer) {
		CustomerDB customerDB = new CustomerDB();
		customerDB.setCustomerName(customer.getFullName());
		customerDB.setCustomerEmail(customer.getEmailId());
		Date todayDate = new Date();
		
		customerDB.setCreatedDate(todayDate);
		customerDB.setUpdatedDate(todayDate);
		customerDB.setIsPrimeUser(false);
		
		
		
		customerRepository.save(customerDB);
		
		
		
		return "Customer Created Successfully!";
	}
	
	@RequestMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		 List<CustomerDB> customerDBList = customerRepository.findAll();
		 List<Customer> customerList = new ArrayList<Customer>();
		 for(CustomerDB customerDB: customerDBList) {
			 Customer customer = new Customer();
			 customer.setCustomerId(customerDB.getCustomerId());
			 customer.setFullName(customerDB.getCustomerName());
			 customer.setEmailId(customerDB.getCustomerEmail());
			 customerList.add(customer);
			 
		 }
		
		return customerList;
	}
	
	@PutMapping("/updateCustomer")
	public String updateCustomerData(@RequestBody Customer customer) {
		Optional<CustomerDB> optionalCustomerDB = customerRepository.findById(customer.getCustomerId());
		CustomerDB customerDB = optionalCustomerDB.get();
		customerDB.setCustomerName(customer.getFullName());
		customerDB.setCustomerEmail(customer.getEmailId());
		customerRepository.save(customerDB);
		return "Customer Information Updated Successfully";
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable("customerId") long customerId) {
		customerRepository.deleteById(customerId);
		return "Customer Deleted Successfully";
	}

}
