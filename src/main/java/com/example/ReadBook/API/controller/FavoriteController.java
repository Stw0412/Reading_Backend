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

import com.example.ReadBook.API.business.FavoriteBusiness;
import com.example.ReadBook.API.json.FavoriteListJson;
import com.example.ReadBook.API.model.Book;
import com.example.ReadBook.API.model.Customer;
import com.example.ReadBook.API.model.Favorite;
import com.example.ReadBook.API.payload.FavoritePayload;
import com.example.ReadBook.API.service.FavoriteService;
import com.example.ReadBook.exception.BaseException;

@RestController
@RequestMapping("/api")
public class FavoriteController {
	@Autowired
	FavoriteService favoriteService;
	
	@Autowired
	FavoriteBusiness favoriteBusiness ;
	
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService ;
	}
	
	@PostMapping(value = "/favorite")
    public ResponseEntity<Void> saveFavorite(@RequestBody FavoritePayload favoritePayload) throws BaseException {
		favoriteBusiness.saveFavorite(favoritePayload);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/favorite")
    public ResponseEntity<List<FavoriteListJson>> getAllFavorite() throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getListAllFavorite());
    }
	
	@GetMapping(value = "/favorite/{id}")
    public ResponseEntity<FavoriteListJson> getFavoriteById(@PathVariable("id") long id) throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getFavoriteById(id));
    }
	
	@GetMapping(value = "/favorite/customer/{customerId}")
    public ResponseEntity<List<FavoriteListJson>> getFavoriteByCustomerId(@PathVariable("customerId") Customer customerId) throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getFavoriteByCustomeId(customerId));
    }
	
	@GetMapping(value = "/favorite/book/{bookId}")
    public ResponseEntity<List<FavoriteListJson>> getFavoriteByBookId(@PathVariable("bookId") Book bookId) throws BaseException {
        return ResponseEntity.ok(favoriteBusiness.getFavoriteByBookId(bookId));
    }
	
	@PutMapping(value = "/favorite/{id}")
    public ResponseEntity<FavoriteListJson> updateFavorite(@PathVariable("id")  long id, @RequestBody FavoritePayload favoritePayload) {
		Optional<Favorite> fData = favoriteService.findOptionalById(id);
		if (fData.isPresent()) {
			favoriteBusiness.updateFavorite(fData.get().getId(), favoritePayload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/favorite/{id}")
    public ResponseEntity<HttpStatus> deleteFavorite(@PathVariable("id") long id) {
		try {
			favoriteBusiness.deleteFavorite(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
