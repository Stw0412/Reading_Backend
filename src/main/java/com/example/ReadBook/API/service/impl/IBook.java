package com.example.ReadBook.API.service.impl;

import java.util.List;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookType;

public interface IBook {
	List<Book> getAllBook();
	Book findById(long id);
	Book findByNameBook(String nameBook);
	Book findByAuthor(String author);
	List<Book> findByTypeId(BookType typeId);
	Book save(Book book);
	void deleteById(long id);
}
