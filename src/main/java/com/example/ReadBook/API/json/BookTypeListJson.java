package com.example.ReadBook.API.json;

import java.util.ArrayList;
import java.util.List;

import com.example.ReadBook.API.model.BookType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookTypeListJson {
	private long id ;
	private String nameType ;
	
	public  static BookTypeListJson pacJson(BookType bookType) {
		// TODO Auto-generated constructor stub
		BookTypeListJson btj = new BookTypeListJson();
		btj.setId(bookType.getId());
		btj.setNameType(bookType.getNameType());
		
		return btj ;
	}
	
	public static List<BookTypeListJson> pacJsons(List<BookType> bookTypes){
		List<BookTypeListJson> btj = new ArrayList<BookTypeListJson>();
		for (BookType bookType : bookTypes) {
			btj.add(pacJson(bookType));
		}
		return btj ;
	}
}