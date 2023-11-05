package com.example.ReadBook.API.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ReadBook.API.business.BookBusibess;
import com.example.ReadBook.API.json.BookListJson;
import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookType;
import com.example.ReadBook.API.payload.BookPayload;
import com.example.ReadBook.API.service.BookService;
import com.example.ReadBook.exception.BaseException;

@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;
    
    @Autowired
    BookBusibess bookBusiness;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @PostMapping(value = "/book")
    public ResponseEntity<Void> saveBook(@RequestBody BookPayload bookPayload) throws BaseException {
        bookBusiness.saveBook(bookPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/book")
    public ResponseEntity<List<BookListJson>> getAllBook() throws BaseException {
        return ResponseEntity.ok(bookBusiness.getListBook());
    }
    
    @GetMapping(value = "/book/{id}")
    public ResponseEntity<BookListJson> getBookById(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(bookBusiness.getBookById(id));
    }

    @GetMapping(value = "/book/bookType/{typeId}")
    public ResponseEntity<List<BookListJson>> getBookByTypeId(@PathVariable("typeId") BookType typeId) throws BaseException {
        return ResponseEntity.ok(bookBusiness.getBookByTypeId(typeId));
    }
    
    @PutMapping(value = "/book/{id}")
    public ResponseEntity<BookListJson> updateBook(@PathVariable("id")  long id, @RequestBody BookPayload bookPayload) {
		Optional<Book> bData = bookService.findOptionalById(id);
		if (bData.isPresent()) {
			bookBusiness.updateBook(bData.get().getId(), bookPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @DeleteMapping(value = "/book/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
		try {
			bookBusiness.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
