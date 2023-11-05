package com.example.ReadBook.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookType;
import com.example.ReadBook.API.repository.BookRepository;
import com.example.ReadBook.API.service.impl.IBook;

@Service
public class BookService implements IBook {
	@Autowired
	BookRepository bookRepository ;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository ;
	}

	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public Book findByNameBook(String nameBook) {
		// TODO Auto-generated method stub
		return bookRepository.findByNameBook(nameBook);
	}

	@Override
	public Book findByAuthor(String author) {
		// TODO Auto-generated method stub
		return bookRepository.findByAuthor(author);
	}

	@Override
	public List<Book> findByTypeId(BookType typeId) {
		// TODO Auto-generated method stub
		return bookRepository.findByTypeId(typeId);
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}
	
	public Optional<Book> findOptionalById(long id){
		return bookRepository.findOptionalById(id);
	}
}
