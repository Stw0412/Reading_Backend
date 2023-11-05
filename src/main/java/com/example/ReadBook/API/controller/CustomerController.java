package com.example.ReadBook.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReadBook.API.business.CustomerBusiness;
import com.example.ReadBook.API.json.CustomerListJson;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.payload.CustomerPayload;
import com.example.ReadBook.API.service.CustomerService;
import com.example.ReadBook.exception.BaseException;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	CustomerService customerService ;
	
	@Autowired
	CustomerBusiness customerBusiness ;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService ;
	}
	
	@PostMapping(value = "/customer")
	public ResponseEntity<Void> saveCustomer(@RequestBody CustomerPayload customerPayload) throws BaseException{
		customerBusiness.saveCustomer(customerPayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/customer")
	public ResponseEntity<List<CustomerListJson>> getAllCustomers() throws BaseException {
		return ResponseEntity.ok(customerBusiness.getListCustomer());
	}
	
	@GetMapping(value = "/customer/{id}")
	public ResponseEntity<CustomerListJson> getCustomerById(@PathVariable("id")  long id) throws BaseException {
		return ResponseEntity.ok(customerBusiness.getCustomerById(id));
	}
	
	@PutMapping(value = "/customer/{id}")
	public ResponseEntity<CustomerListJson> updateCustomer(@PathVariable("id")  long id, @RequestBody CustomerPayload customerPayload) {
		Optional<Customer> ctmData = customerService.findOptionalById(id);
		if (ctmData.isPresent()) {
			customerBusiness.updateCustomer(ctmData.get().getId(), customerPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/customer/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
		try {
			customerBusiness.deleteCustomer(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
