package com.example.ReadBook.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.model.BookType;
import com.example.ReadBook.API.repository.BookTypeRepository;
import com.example.ReadBook.API.service.impl.IBookType;

@Service
public class BookTypeService implements IBookType {
	@Autowired
	BookTypeRepository bookTypeRepository ;
	
	public BookTypeService(BookTypeRepository bookTypeRepository) {
		this.bookTypeRepository = bookTypeRepository ;
	}

	@Override
	public List<BookType> getAllBookType() {
		// TODO Auto-generated method stub
		return bookTypeRepository.findAll();
	}

	@Override
	public BookType findById(long id) {
		// TODO Auto-generated method stub
		return bookTypeRepository.findById(id);
	}

	@Override
	public BookType findByNameType(String nameType) {
		// TODO Auto-generated method stub
		return bookTypeRepository.findByNameType(nameType);
	}

	@Override
	public BookType save(BookType bookType) {
		// TODO Auto-generated method stub
		return bookTypeRepository.save(bookType);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		bookTypeRepository.deleteById(id);
	}
	
	public Optional<BookType> findOptionalById(long id){
		return bookTypeRepository.findOptionalById(id);
	}

}
