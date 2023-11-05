package com.example.ReadBook.API.service.impl;

import java.util.List;

import com.example.ReadBook.API.model.BookType;

public interface IBookType {
	List<BookType> getAllBookType();
	BookType findById(long id);
	BookType findByNameType(String nameType);
	BookType save(BookType bookType);
	void deleteById(long id);
}
