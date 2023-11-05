package com.example.ReadBook.API.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookType;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Book findById(long id);
	Book findByNameBook(String nameBook);
	Book findByAuthor(String author);
	List<Book> findByTypeId(BookType typeId);
	Optional<Book> findOptionalById(long id);
}
