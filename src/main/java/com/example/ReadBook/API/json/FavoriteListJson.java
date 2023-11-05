package com.example.ReadBook.API.json;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.model.Favorite;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoriteListJson {
	private long id ;
	private Customer customerId ;
	private Book bookId ;
	private Date createdAt ;
	
	public static FavoriteListJson packJson(Favorite favorite) {
		FavoriteListJson flj = new FavoriteListJson();
		flj.setId(favorite.getId());
		flj.setCustomerId(favorite.getCustomerId());
		flj.setBookId(favorite.getBookId());
		flj.setCreatedAt(favorite.getCreatedAt());
		
		return flj ;
	}
	
	public static List<FavoriteListJson> packJsons(List<Favorite> favorites){
		List<FavoriteListJson> flj = new ArrayList<FavoriteListJson>();
		for (Favorite favorite : favorites) {
			flj.add(packJson(favorite));
		}
		return flj ;
	}
}
