package com.example.ReadBook.API.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookContent;

@Repository
public interface BookContentRepository extends JpaRepository<BookContent, Long> {
	BookContent findById(long id);
	List<BookContent> findByBookId(Book bookId);
	Optional<BookContent> findOptionalById(long id);
}
