package com.example.ReadBook.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ReadBook.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookException extends BaseException {
	private static final long seriaVersionUID = 1L ;
	
	public BookException (String code, HttpStatus status) {
		super("Book." + code, status);
	}
	public static BookException  bookExcption() {
		return new BookException ("findBook.notFound", HttpStatus.BAD_REQUEST);
	}
}
