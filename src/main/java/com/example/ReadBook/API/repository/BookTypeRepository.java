package com.example.ReadBook.API.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ReadBook.API.model.BookType;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Long> {
	BookType findById(long id);
	BookType findByNameType(String nameType);
	Optional<BookType> findOptionalById(long id);
}
