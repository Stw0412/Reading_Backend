package com.example.ReadBook.API.payload;

import java.sql.Date;

import com.example.ReadBook.API.model.Book;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookContentPayload {
	private long pageNumber ;
	private String text ;
	private Date createdAt ;
	private Book bookId ;
}
