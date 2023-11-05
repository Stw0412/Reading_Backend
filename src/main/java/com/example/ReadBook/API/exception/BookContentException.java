package com.example.ReadBook.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ReadBook.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookContentException extends BaseException {
private static final long seriaVersionUID = 1L ;
	
	public BookContentException (String code, HttpStatus status) {
		super("BookContent." + code, status);
	}
	public static BookContentException  bookContentExcption() {
		return new BookContentException ("findBookContent.notFound", HttpStatus.BAD_REQUEST);
	}
}
