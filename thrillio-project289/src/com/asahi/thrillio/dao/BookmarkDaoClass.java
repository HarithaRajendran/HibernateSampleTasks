package com.asahi.thrillio.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.BookUser;
import com.asahi.thrillio.entity.Movie;
import com.asahi.thrillio.entity.MovieUser;
import com.asahi.thrillio.entity.User;

@Repository
public class BookmarkDaoClass implements BookmarkDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Book> getBooks() {

		Session session = factory.getCurrentSession();

		Query<Book> theQuery = session.createQuery("from Book", Book.class);

		List<Book> books = theQuery.getResultList();

		return books;
	}

	@Override
	public List<Movie> getMovies() {
		Session session = factory.getCurrentSession();

		Query<Movie> theQuery = session.createQuery("from Movie", Movie.class);

		List<Movie> movies = theQuery.getResultList();

		return movies;
	}

	@Override
	public List<Book> getBook(int bookId) {
		Session session = factory.getCurrentSession();

		Query<Book> theQuery = session.createQuery("from Book where id =:bookId", Book.class);

		theQuery.setParameter("bookId", bookId);

		List<Book> book = theQuery.getResultList();

		return book;
	}

	@Override
	public List<Movie> getMovie(int movieId) {
		Session session = factory.getCurrentSession();

		Query<Movie> theQuery = session.createQuery("from Movie where id =:movieId", Movie.class);

		theQuery.setParameter("movieId", movieId);

		List<Movie> movie = theQuery.getResultList();

		return movie;

	}

	private static BookUser bookuserfilter(BookUser bookuser, List<BookUser> listOfBookUser) {

		List<BookUser> filteredData = listOfBookUser.stream()
				.filter(data -> ((data.getBookId()).equals(bookuser.getBookId())
						&& data.getUserId().equals(bookuser.getUserId())))
				.collect(Collectors.toList());

		BookUser bookUser = null;

		for (BookUser bu : filteredData) {
			bookUser = bu;
		}
		return bookUser;
	}

	@Override
	public void saveUserToBook(User currentUser, int bookId) {

		Session session = factory.getCurrentSession();

		List<BookUser> listOfBookUser = new ArrayList<>();

		Query<BookUser> query = session.createQuery("from BookUser",BookUser.class);

		listOfBookUser = query.getResultList();

		BookUser bookuser = new BookUser();
		bookuser.setBookId(bookId);
		bookuser.setUserId(currentUser.getId());

		BookUser onebookUser = bookuserfilter(bookuser, listOfBookUser);

		System.out.println("ffff "+onebookUser);

		try {
			if (onebookUser.equals(null)) {
				System.out.println("Already an User");
			}
			
		} catch (NullPointerException e) {
				session.save(bookuser);
		}

	}

	private static MovieUser movieuserfilter(MovieUser movieuser, List<MovieUser> listOfMovieUser) {

		List<MovieUser> filteredData = listOfMovieUser.stream()
				.filter(data -> ((data.getMovieId()).equals(movieuser.getMovieId())
						&& data.getUserId().equals(movieuser.getUserId())))
				.collect(Collectors.toList());

		MovieUser movieUser = null;

		for (MovieUser mu : filteredData) {
			movieUser = mu;
		}
		return movieUser;
	}

	@Override
	public void saveUserToMovie(User currentUser, int movieId) {
		Session session = factory.getCurrentSession();

		List<MovieUser> listOfBookUser = new ArrayList<>();

		Query<MovieUser> query = session.createQuery("from MovieUser",MovieUser.class);

		listOfBookUser = query.getResultList();

		MovieUser movieuser = new MovieUser();
		movieuser.setMovieId(movieId);
		movieuser.setUserId(currentUser.getId());

		MovieUser onemovieUser = movieuserfilter(movieuser, listOfBookUser);

		System.out.println(onemovieUser);

		try {
			if (onemovieUser.equals(null)) {
				System.out.println("Already an User");
			}
		} catch (NullPointerException e) {
			session.save(movieuser);
		}

	}

	@Override
	public List<Book> viewBooks(User logginUser) {

		Session session = factory.getCurrentSession();

		List<Book> bookmarkedBooks = new ArrayList<Book>();

		Query<BookUser> theQuery = session.createQuery("from BookUser where user_id =:userId", BookUser.class);

		theQuery.setParameter("userId", logginUser.getId());

		List<BookUser> bookUserList = theQuery.getResultList();

		for (BookUser bu : bookUserList) {

			Book books = session.get(Book.class, bu.getBookId());

			bookmarkedBooks.add(books);
		}

		return bookmarkedBooks;
	}

	@Override
	public List<Movie> viewMovies(User logginUser) {

		Session session = factory.getCurrentSession();

		Query<MovieUser> theQuery = session.createQuery("from MovieUser where userId =:userId", MovieUser.class);

		theQuery.setParameter("userId", logginUser.getId());

		List<MovieUser> movieUserList = theQuery.getResultList();

		List<Movie> bookmarkedMovies = new ArrayList<>();

		for (MovieUser mu : movieUserList) {

			Movie movies = session.get(Movie.class, mu.getMovieId());

			bookmarkedMovies.add(movies);

		}

		return bookmarkedMovies;
	}

	@Override
	public void deleteMyBook(Integer userId, Integer bookId) {
		Session session = factory.getCurrentSession();

		Query<BookUser> theQuery = session.createQuery("from BookUser where userId=:userId and bookId=:bookId",
				BookUser.class);
		theQuery.setParameter("userId", userId);
		theQuery.setParameter("bookId", bookId);

		List<BookUser> itemToDelete = theQuery.getResultList();

		System.out.println("bookUserDeleted " + itemToDelete);

		for (BookUser btd : itemToDelete) {
			session.delete(btd);
		}

	}

	@Override
	public void deleteMyMovie(Integer userId, Integer movieId) {
		Session session = factory.getCurrentSession();

		Query<MovieUser> theQuery = session.createQuery("from MovieUser where userId=:userId and movieId=:movieId",
				MovieUser.class);
		theQuery.setParameter("userId", userId);
		theQuery.setParameter("movieId", movieId);

		List<MovieUser> itemToDelete = theQuery.getResultList();

		System.out.println("itemToDelete "+itemToDelete);
		

		for (MovieUser mtd : itemToDelete) {
			session.delete(mtd);
		}
	}

}
























// System.out.println("llll"+currentUser);
//
// Movie movie = session.get(Movie.class, movieId);
//
// // movie.addUsers(currentUser);
//
// currentUser.addMovie(movie);
//
// session.save(currentUser);
//
// System.out.println("Success.....");

// ------------------------------

// //Query<BookUser> theQuery = session.createQuery("from Book");
//
// //List<BookUser> bookUser = theQuery.getResultList();
// System.out.println("llll"+currentUser);
//
// Book book = session.get(Book.class, bookId);
//
// //book.addUsers(currentUser);
//
// currentUser.addBook(book);
//
// session.update(currentUser);
