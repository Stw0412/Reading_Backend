package com.example.ReadBook.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ReadBook.API.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findById(long id);
	Customer findByFristName(String fristName);
	Customer findByLastName(String lastName);
	Customer findByUserName(String userName);
	Optional<Customer> findOptionalById(long id);
}
