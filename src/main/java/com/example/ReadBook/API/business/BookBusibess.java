package com.example.ReadBook.API.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.json.BookListJson;
import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookType;
import com.example.ReadBook.API.payload.BookPayload;
import com.example.ReadBook.API.service.BookService;

@Service
public class BookBusibess {
	@Autowired
	BookService bookService ;
	
	public List<BookListJson> getListBook(){
		return BookListJson.pacJsons(bookService.getAllBook());
	}
	
	public BookListJson getBookById(long id) {
		return BookListJson.packJson(bookService.findById(id));
	}
	
	public List<BookListJson> getBookByTypeId(BookType typeId) {
		return BookListJson.pacJsons(bookService.findByTypeId(typeId));
	}
	
	
	
	public void saveBook(BookPayload bpl) {
		Book book = new Book(
				bpl.getNameBook(),
				bpl.getAuthor(),
				bpl.getDescription(),
				bpl.getCreatedAt(),
				bpl.getTypeId());
		bookService.save(book);
	}
	
	public void updateBook(long id, BookPayload bookPayload) {
		Book book = bookService.findById(id);
		book.setNameBook(bookPayload.getNameBook());
		book.setAuthor(bookPayload.getAuthor());
		book.setDescription(bookPayload.getDescription());
		book.setTypeId(bookPayload.getTypeId());
	}
	
	public void deleteBook(long id) {
		bookService.deleteById(id);
	}
}
