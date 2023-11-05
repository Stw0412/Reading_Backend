package com.example.ReadBook.API.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.json.BookTypeListJson;
import com.example.ReadBook.API.model.BookType;
import com.example.ReadBook.API.payload.BookTypePayload;
import com.example.ReadBook.API.service.BookTypeService;

@Service
public class BookTypeBusibess {
	@Autowired
	BookTypeService bookTypeService ;
	
	public List<BookTypeListJson> getListBookType(){
		return BookTypeListJson.pacJsons(bookTypeService.getAllBookType());
	}
	
	public BookTypeListJson getBookTypeById(long id) {
		return BookTypeListJson.pacJson(bookTypeService.findById(id));
	}
	
	public void saveBookType(BookTypePayload btp) {
		BookType bookType = new BookType(
				btp.getNameType());
		bookTypeService.save(bookType);
	}
	public void updateBookType(long id, BookTypePayload bookTypePayload) {
		BookType bookType = bookTypeService.findById(id);
		bookType.setNameType(bookTypePayload.getNameType());
		bookTypeService.save(bookType);
	}
	
	public void deleteBookType(long id) {
		bookTypeService.deleteById(id);
	}
}
