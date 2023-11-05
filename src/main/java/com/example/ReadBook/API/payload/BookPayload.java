package com.example.ReadBook.API.payload;

import java.sql.Date;

import com.example.ReadBook.API.model.BookType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookPayload {
	
	private String nameBook ;
	private String author ;
	private String description ;
	private Date createdAt ;
	private BookType typeId ;
}
