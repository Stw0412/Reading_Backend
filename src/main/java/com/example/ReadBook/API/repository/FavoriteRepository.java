package com.example.ReadBook.API.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.model.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
	Favorite findById(long id);
	List<Favorite> findByCustomerId(Customer customerId);
	List<Favorite> findByBookId(Book bookId);
	Optional<Favorite> findOptionalById(long id);
}
