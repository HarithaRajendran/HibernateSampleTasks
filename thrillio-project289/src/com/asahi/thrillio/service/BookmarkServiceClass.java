package com.asahi.thrillio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asahi.thrillio.dao.BookmarkDao;
import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.Movie;
import com.asahi.thrillio.entity.User;

@Service
public class BookmarkServiceClass implements BookmarkService {

	@Autowired
	private BookmarkDao bookmarkDao;

	@Override
	@Transactional
	public List<Book> getBooks() {

		List<Book> books = bookmarkDao.getBooks();

		return books;
	}

	@Override
	@Transactional
	public List<Movie> getMovies() {

		List<Movie> movies = bookmarkDao.getMovies();

		return movies;
	}

	@Override
	@Transactional
	public List<Book> getBook(int bookId) {

		List<Book> book = bookmarkDao.getBook(bookId);

		return book;
	}

	@Override
	@Transactional
	public List<Movie> getMovie(int movieId) {

		List<Movie> movie = bookmarkDao.getMovie(movieId);

		return movie;
	}

	@Override
	@Transactional
	public void saveUserToBook(User currentUser, int bookId) {

		bookmarkDao.saveUserToBook(currentUser, bookId);
	}

	@Override
	@Transactional
	public void saveUserToMovie(User currentUser, int movieId) {
		
		bookmarkDao.saveUserToMovie(currentUser, movieId);

	}

	@Override
	@Transactional
	public List<Book> viewBooks(User logginUser) {
		
		List<Book> bookmarkedBooks = bookmarkDao.viewBooks(logginUser);
		
		return bookmarkedBooks;
	}

	@Override
	@Transactional
	public List<Movie> viewMovies(User logginUser) {
		
		List<Movie> bookmarkedMovies = bookmarkDao.viewMovies(logginUser);
		
		return bookmarkedMovies;
	}

	@Override
	@Transactional
	public void deleteMyBook(Integer userId, Integer bookId) {
		bookmarkDao.deleteMyBook(userId,bookId);
	}

	@Override
	@Transactional
	public void deleteMyMovie(Integer userId, Integer movieId) {
		bookmarkDao.deleteMyMovie(userId,movieId);
	}

}
