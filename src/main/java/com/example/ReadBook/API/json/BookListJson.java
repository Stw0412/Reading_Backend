package com.example.ReadBook.API.json;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.BookType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookListJson {
	private long id ;
	private String nameBook ;
	private String author ;
	private String description ;
	private Date createdAt ;
	private BookType typeId ;
	
	public static BookListJson packJson(Book book) {
		BookListJson blj = new BookListJson();
		blj.setId(book.getId());
		blj.setNameBook(book.getNameBook());
		blj.setAuthor(book.getAuthor());
		blj.setDescription(book.getDescription());
		blj.setCreatedAt(book.getCreatedAt());
		blj.setTypeId(book.getTypeId());
		
		return blj ;
	}
	
	public static List<BookListJson> pacJsons(List<Book> books){
		List<BookListJson> blj = new ArrayList<BookListJson>();
		for (Book book : books) {
			blj.add(packJson(book));
		}
		return blj ;
	}
}
