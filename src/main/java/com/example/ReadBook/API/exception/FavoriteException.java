package com.example.ReadBook.API.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.ReadBook.exception.BaseException;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FavoriteException extends BaseException {
	private static final long seriaVersionUID = 1L ;
	public FavoriteException (String code, HttpStatus status) {
		super("Favorite." + code, status);
	}
	public static FavoriteException  favoriteException() {
		return new FavoriteException ("findFavorite.notFound", HttpStatus.BAD_REQUEST);
	}
}
