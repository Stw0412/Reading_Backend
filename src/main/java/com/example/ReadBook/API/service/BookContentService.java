package com.example.ReadBook.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookContent;
import com.example.ReadBook.API.repository.BookContentRepository;
import com.example.ReadBook.API.service.impl.IBookContent;

@Service
public class BookContentService implements IBookContent {
	
	@Autowired
	BookContentRepository bookContentRepository ;
	
	public BookContentService(BookContentRepository bookContentRepository) {
		this.bookContentRepository = bookContentRepository ;
	}

	@Override
	public List<BookContent> getAllBookContent() {
		// TODO Auto-generated method stub
		return bookContentRepository.findAll();
	}

	@Override
	public BookContent findById(long id) {
		// TODO Auto-generated method stub
		return bookContentRepository.findById(id);
	}

	@Override
	public List<BookContent> findByBookId(Book bookId) {
		// TODO Auto-generated method stub
		return bookContentRepository.findByBookId(bookId);
	}

	@Override
	public BookContent save(BookContent bookContent) {
		// TODO Auto-generated method stub
		return bookContentRepository.save(bookContent);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		bookContentRepository.deleteById(id);
	}
	
	public Optional<BookContent> findOptionalById(long id){
		return bookContentRepository.findOptionalById(id);
	}
}
