package com.example.ReadBook.API.service.impl;

import java.util.List;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.model.Favorite;

public interface IFavorite {
	List<Favorite> getAllFavorites();
	Favorite findById(long id);
	List<Favorite> findByCustomerId(Customer customerId);
	List<Favorite> findByBookId(Book bookId);
	Favorite save(Favorite favorite) ;
	void deleteById(long id);
}
