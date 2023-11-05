package com.example.ReadBook.API.json;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookContent;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookContentListJson {
	private long id ;
	private long pageNumber ;
	private String text ;
	private Date createdAt ;
	private Book bookId ;
	
	public static BookContentListJson packJson(BookContent bookContent) {
		BookContentListJson bcl = new BookContentListJson();
		bcl.setId(bookContent.getId());
		bcl.setPageNumber(bookContent.getPageNumber());
		bcl.setText(bookContent.getText());
		bcl.setCreatedAt(bookContent.getCreatedAt());
		bcl.setBookId(bookContent.getBookId());
		
		return bcl ;
	}
	
	public static List<BookContentListJson> packJsons(List<BookContent> bookContents){
		List<BookContentListJson> bcl = new ArrayList<BookContentListJson>();
		for (BookContent bookContent : bookContents) {
			bcl.add(packJson(bookContent));
		}
		return bcl ;
	}
}
