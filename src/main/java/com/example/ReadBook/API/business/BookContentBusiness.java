package com.example.ReadBook.API.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.json.BookContentListJson;
import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookContent;
import com.example.ReadBook.API.payload.BookContentPayload;
import com.example.ReadBook.API.service.BookContentService;

@Service
public class BookContentBusiness {
	@Autowired
	BookContentService bookContentService ;
	
	public List<BookContentListJson> getListBookContent(){
		return BookContentListJson.packJsons(bookContentService.getAllBookContent());
	}
	
	public BookContentListJson getBookContentById(long id) {
		return BookContentListJson.packJson(bookContentService.findById(id));
	}
	
	public List<BookContentListJson> getBookContentByBookId(Book bookId){
		return BookContentListJson.packJsons(bookContentService.findByBookId(bookId));
	}
	
	public void saveBookContent(BookContentPayload bcp) {
		BookContent bookContent = new BookContent(
				bcp.getPageNumber(),
				bcp.getText(),
				bcp.getCreatedAt(),
				bcp.getBookId());
		bookContentService.save(bookContent);
	}
	
	public void updateBookContent(long id, BookContentPayload bookContentPayload) {
		BookContent bookContent = bookContentService.findById(id);
		bookContent.setPageNumber(bookContentPayload.getPageNumber());
		bookContent.setText(bookContentPayload.getText());
		bookContent.setCreatedAt(bookContentPayload.getCreatedAt());
		bookContent.setBookId(bookContentPayload.getBookId());
	}
	
	public void deleteBookContent(long id) {
		bookContentService.deleteById(id);
	}
}
