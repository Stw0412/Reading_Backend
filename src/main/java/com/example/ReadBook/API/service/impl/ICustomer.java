package com.example.ReadBook.API.service.impl;

import java.util.List;

import com.example.ReadBook.API.model.Customer;

public interface ICustomer {
	List<Customer> getAllCustomer();
	Customer findById(long id);
	Customer findByFristName(String fristName);
	Customer findByLastName(String lastName);
	Customer findByUserName(String userName);
	Customer save(Customer customer);
	void deleteById(long id);
}
