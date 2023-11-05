package com.example.ReadBook.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ReadBook.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookTypeException extends BaseException {
	public BookTypeException (String code, HttpStatus status) {
		super("BookType." + code, status);
	}
	public static BookTypeException  bookTypeExcption() {
		return new BookTypeException ("findBookType.notFound", HttpStatus.BAD_REQUEST);
	}
}
