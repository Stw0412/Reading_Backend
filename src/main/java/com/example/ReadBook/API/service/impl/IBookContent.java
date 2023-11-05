package com.example.ReadBook.API.service.impl;

import java.util.List;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookContent;

public interface IBookContent {
	List<BookContent> getAllBookContent();
	BookContent findById(long id);
	List<BookContent> findByBookId(Book bookId);
	BookContent save(BookContent bookContent) ;
	void deleteById(long id);
}
