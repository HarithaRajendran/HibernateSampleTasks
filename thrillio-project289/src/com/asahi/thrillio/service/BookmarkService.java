package com.asahi.thrillio.service;

import java.util.List;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.Movie;
import com.asahi.thrillio.entity.User;

public interface BookmarkService {
	public List<Book> getBooks();
	
	public List<Movie> getMovies();
	
	public List<Book> getBook(int bookId);

	public List<Movie> getMovie(int movieId);

	void saveUserToBook(User currentUser, int bookId);
	
	void saveUserToMovie(User currentUser,int movieId);

	public List<Book> viewBooks(User logginUser);

	public List<Movie> viewMovies(User logginUser);

	public void deleteMyBook(Integer userId, Integer bookId);

	public void deleteMyMovie(Integer userId, Integer movieId);

}
