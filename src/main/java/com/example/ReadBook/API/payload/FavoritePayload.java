package com.example.ReadBook.API.payload;

import java.sql.Date;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoritePayload {
	private Customer customerId ;
	private Book bookId ;
	private Date createdAt ;
}
