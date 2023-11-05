package com.example.ReadBook.API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.model.Favorite;
import com.example.ReadBook.API.repository.FavoriteRepository;
import com.example.ReadBook.API.service.impl.IFavorite;

@Service
public class FavoriteService implements IFavorite{
	@Autowired
	FavoriteRepository favoriteRepository ;
	
	public FavoriteService ( FavoriteRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository ;
	}

	@Override
	public List<Favorite> getAllFavorites() {
		// TODO Auto-generated method stub
		return favoriteRepository.findAll();
	}

	@Override
	public Favorite findById(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findById(id);
	}

	@Override
	public List<Favorite> findByCustomerId(Customer customerId) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByCustomerId(customerId);
	}

	@Override
	public List<Favorite> findByBookId(Book bookId) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByBookId(bookId);
	}

	@Override
	public Favorite save(Favorite favorite) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(favorite);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		favoriteRepository.deleteById(id);
	}
	
	public Optional<Favorite> findOptionalById(long id){
		return favoriteRepository.findOptionalById(id);
	}

}
