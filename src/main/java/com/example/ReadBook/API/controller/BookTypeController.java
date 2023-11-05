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

import com.example.ReadBook.API.business.BookTypeBusibess;
import com.example.ReadBook.API.json.BookTypeListJson;
import com.example.ReadBook.API.model.BookType;
import com.example.ReadBook.API.payload.BookTypePayload;
import com.example.ReadBook.API.service.BookTypeService;
import com.example.ReadBook.exception.BaseException;

@RestController
@RequestMapping("/api")
public class BookTypeController {
	@Autowired
	BookTypeService bookTypeService ;
	
	@Autowired
	BookTypeBusibess bookTypeBusibess ;
	
	public BookTypeController(BookTypeService bookTypeService) {
		this.bookTypeService = bookTypeService ;
	}
	
	@PostMapping(value = "/bookType")
	public ResponseEntity<Void> saveBookType(@RequestBody BookTypePayload bookTypePayload) throws BaseException{
		bookTypeBusibess.saveBookType(bookTypePayload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/bookType")
	public ResponseEntity<List<BookTypeListJson>> getAllBookType() throws BaseException {
		return ResponseEntity.ok(bookTypeBusibess.getListBookType());
	}
	
	@GetMapping(value = "/bookType/{id}")
	public ResponseEntity<BookTypeListJson> getBookTypeById(@PathVariable("id")  long id) throws BaseException {
		return ResponseEntity.ok(bookTypeBusibess.getBookTypeById(id));
	}
	
	@PutMapping(value = "/bookType/{id}")
	public ResponseEntity<BookTypeListJson> updateBookType(@PathVariable("id")  long id, @RequestBody BookTypePayload bookTypePayload) {
		Optional<BookType> btData = bookTypeService.findOptionalById(id);
		if (btData.isPresent()) {
			bookTypeBusibess.updateBookType(btData.get().getId(), bookTypePayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/bookType/{id}")
	public ResponseEntity<HttpStatus> deleteBookType(@PathVariable("id") long id) {
		try {
			bookTypeBusibess.deleteBookType(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
