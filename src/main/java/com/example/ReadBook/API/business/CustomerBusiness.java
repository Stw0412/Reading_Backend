package com.example.ReadBook.API.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.json.CustomerListJson;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.payload.CustomerPayload;
import com.example.ReadBook.API.service.CustomerService;

@Service
public class CustomerBusiness {
	@Autowired
	CustomerService customerService ;
	
	public List<CustomerListJson> getListCustomer(){
		return CustomerListJson.pacJsons(customerService.getAllCustomer());
	}
	
	public CustomerListJson getCustomerById(long id) {
		return CustomerListJson.packJson(customerService.findById(id));
	}
	
	public CustomerListJson getCustomerByUserName(String userName) {
		return CustomerListJson.packJson(customerService.findByUserName(userName));
	}
	
	public void saveCustomer(CustomerPayload cpl) {
		Customer customer = new Customer(
							cpl.getFristName(),
							cpl.getLastName(),
							cpl.getUserName(),
							cpl.getPassword());
		customerService.save(customer);
	}
	
	public void updateCustomer(long id, CustomerPayload customerPayload) {
		Customer customer = customerService.findById(id);
		customer.setFristName(customerPayload.getFristName());
		customer.setLastName(customerPayload.getLastName());
		customer.setPassword(customerPayload.getPassword());
		customerService.save(customer);
	}
	
	public void deleteCustomer(long id) {
		customerService.deleteById(id);
	}
}
