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

import com.example.ReadBook.API.business.BookContentBusiness;
import com.example.ReadBook.API.json.BookContentListJson;
import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookContent;
import com.example.ReadBook.API.payload.BookContentPayload;
import com.example.ReadBook.API.service.BookContentService;
import com.example.ReadBook.exception.BaseException;

@RestController
@RequestMapping("/api")
public class BookContentController {
	@Autowired
	BookContentService bookContentService ;
	
	@Autowired
	BookContentBusiness bookContentBusiness ;
	
	public BookContentController(BookContentService bookContentService) {
		this.bookContentService = bookContentService ;
	}
	
	@PostMapping(value = "/bookContent")
    public ResponseEntity<Void> saveBookContent(@RequestBody BookContentPayload bookContentPayload) throws BaseException {
		bookContentBusiness.saveBookContent(bookContentPayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
    @GetMapping(value = "/bookContent")
    public ResponseEntity<List<BookContentListJson>> getAllBookContent() throws BaseException {
        return ResponseEntity.ok(bookContentBusiness.getListBookContent());
    }
    
    @GetMapping(value = "/bookContent/{id}")
    public ResponseEntity<BookContentListJson> getBookContentById(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(bookContentBusiness.getBookContentById(id));
    }
    
    @GetMapping(value = "/bookContent/book/{bookId}")
    public ResponseEntity<List<BookContentListJson>> getBookContentByTypeId(@PathVariable("bookId") Book bookId) throws BaseException {
        return ResponseEntity.ok(bookContentBusiness.getBookContentByBookId(bookId));
    }
    
    @PutMapping(value = "/bookContent/{id}")
    public ResponseEntity<BookContentListJson> updateBookContent(@PathVariable("id")  long id, @RequestBody BookContentPayload bookContentPayload) {
		Optional<BookContent> bcData = bookContentService.findOptionalById(id);
		if (bcData.isPresent()) {
			bookContentBusiness.updateBookContent(bcData.get().getId(), bookContentPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @DeleteMapping(value = "/bookContent/{id}")
    public ResponseEntity<HttpStatus> deleteBookContent(@PathVariable("id") long id) {
		try {
			bookContentBusiness.deleteBookContent(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
