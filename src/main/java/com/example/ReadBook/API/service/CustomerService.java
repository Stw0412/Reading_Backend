package com.example.ReadBook.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.repository.CustomerRepository;
import com.example.ReadBook.API.service.impl.ICustomer;

@Service
public class CustomerService implements ICustomer {
	@Autowired
	CustomerRepository customerRepository ;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository ;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id);
	}

	@Override
	public Customer findByFristName(String fristName) {
		// TODO Auto-generated method stub
		return customerRepository.findByFristName(fristName);
	}

	@Override
	public Customer findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return customerRepository.findByLastName(lastName);
	}

	@Override
	public Customer findByUserName(String userName) {
		// TODO Auto-generated method stub
		return customerRepository.findByUserName(userName);
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}
	
	public Optional<Customer> findOptionalById(long id){
		return customerRepository.findOptionalById(id);
	}
}
