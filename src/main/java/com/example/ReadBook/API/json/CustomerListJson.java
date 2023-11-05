package com.example.ReadBook.API.json;

import java.util.ArrayList;
import java.util.List;

import com.example.ReadBook.API.model.Customer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerListJson {
	private long id ;
	private String fristName ;
	private String lastName ;
	private String userName ;
	private String password ;
	
	public static CustomerListJson packJson(Customer customer) {
		CustomerListJson clj = new CustomerListJson();
		clj.setId(customer.getId());
		clj.setFristName(customer.getFristName());
		clj.setLastName(customer.getLastName());
		clj.setUserName(customer.getUserName());
		clj.setPassword(customer.getPassword());
		
		return clj ;
	}
	
	public static List<CustomerListJson> pacJsons(List<Customer> customers) {
		List<CustomerListJson> clj = new ArrayList<CustomerListJson>();
		for (Customer customer : customers) {
			clj.add(packJson(customer));
		}
		return clj ;
	}
}
