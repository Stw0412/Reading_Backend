package com.example.ReadBook.API.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadBook.API.json.FavoriteListJson;
import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.model.Favorite;
import com.example.ReadBook.API.payload.FavoritePayload;
import com.example.ReadBook.API.service.FavoriteService;

@Service
public class FavoriteBusiness {
	@Autowired
	FavoriteService favoriteService ;
	
	public List<FavoriteListJson> getListAllFavorite() {
		return FavoriteListJson.packJsons(favoriteService.getAllFavorites());
	}
	
	public FavoriteListJson getFavoriteById(long id) {
		return FavoriteListJson.packJson(favoriteService.findById(id));
	}
	
	public List<FavoriteListJson> getFavoriteByCustomeId(Customer customerId) {
		return FavoriteListJson.packJsons(favoriteService.findByCustomerId(customerId));
	}
	
	public List<FavoriteListJson> getFavoriteByBookId(Book bookId){
		return FavoriteListJson.packJsons(favoriteService.findByBookId(bookId));
	}
	
	public void saveFavorite(FavoritePayload fpl) {
		Favorite favorite = new Favorite(
				fpl.getCustomerId(),
				fpl.getBookId(),
				fpl.getCreatedAt());
		favoriteService.save(favorite);
	}
	
	public void updateFavorite(long id , FavoritePayload fpl) {
		Favorite favorite = favoriteService.findById(id);
		favorite.setCustomerId(fpl.getCustomerId());
		favorite.setBookId(fpl.getBookId());
		favorite.setCreatedAt(fpl.getCreatedAt());
	}
	
	public void deleteFavorite(long id) {
		favoriteService.deleteById(id);
	}
}
