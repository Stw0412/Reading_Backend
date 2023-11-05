package com.example.ReadBook.API.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ReadBook.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerException extends BaseException {
private static final long seriaVersionUID = 1L ;
	
	public CustomerException (String code, HttpStatus status) {
		super("Employees." + code, status);
	}
	public static CustomerException  employeesExcption() {
		return new CustomerException ("findEmployees.notFound", HttpStatus.BAD_REQUEST);
	}
}
