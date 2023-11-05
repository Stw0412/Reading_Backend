package com.example.ReadBook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Service
@Setter
@Getter
public abstract class BaseException extends Exception {
private static final long serialVersionUID = - 9121095558274093107L ;
	
	private final HttpStatus status ;
	
	protected BaseException(String code) {
		super(code);
		this.status = HttpStatus.EXPECTATION_FAILED;
	}
	protected BaseException(String code, HttpStatus status) {
		super(code);
		this.status = status;
	}
	public HttpStatus getHttpStatus() {
		return status ;
	}
}
