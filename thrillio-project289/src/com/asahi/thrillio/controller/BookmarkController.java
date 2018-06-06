package com.asahi.thrillio.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.FilterBooksEntity;
import com.asahi.thrillio.entity.Movie;
import com.asahi.thrillio.entity.User;
import com.asahi.thrillio.service.BookmarkService;

@Controller
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;

	@Value("#{filteringOptions}")
	private Map<String, String> filteringOptions;

	User logginUser = null;

	@GetMapping("/books")
	public String booksPage(Model model, Model bookModel, HttpSession session) {

		model.addAttribute("toFilter", new FilterBooksEntity());

		model.addAttribute("filterBy", filteringOptions);

		logginUser = (User) session.getAttribute("sessionUser");

		List<Book> books = bookmarkService.getBooks();

		bookModel.addAttribute("books", books);

		return "books";
	}

	@GetMapping("/movies")
	public String moviesPage(Model movieModel, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		List<Movie> movies = bookmarkService.getMovies();

		movieModel.addAttribute("movies", movies);

		return "movies";
	}

	@GetMapping("/book")
	public String bookPage(@RequestParam("booksId") int bookId, Model model) {

		List<Book> selectedBook = bookmarkService.getBook(bookId);

		model.addAttribute("book", selectedBook);

		return "book";
	}

	@GetMapping("/movie")
	public String moviePage(@RequestParam("moviesId") int movieId, Model model) {

		List<Movie> selectedMovie = bookmarkService.getMovie(movieId);

		model.addAttribute("movie", selectedMovie);

		return "movie";
	}

	@RequestMapping("/book/bookmark")
	public String bookmarkBook(@RequestParam("bookId") int bookId, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		bookmarkService.saveUserToBook(logginUser, bookId);

		return "redirect:/books";
	}

	@RequestMapping("/movie/bookmark")
	public String bookmarkMovie(@RequestParam("movieId") int movieId, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		bookmarkService.saveUserToMovie(logginUser, movieId);

		return "redirect:/movies";
	}

	@RequestMapping("/myBooks")
	public String viewBooks(Model model, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		List<Book> bookmarkedBooks = bookmarkService.viewBooks(logginUser);

		model.addAttribute("books", bookmarkedBooks);

		return "view-books";
	}

	@RequestMapping("/myMovies")
	public String viewMovies(Model model, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		List<Movie> bookmarkedMovie = bookmarkService.viewMovies(logginUser);

		model.addAttribute("movies", bookmarkedMovie);

		return "view-movies";
	}

	@RequestMapping("/backtohome")
	public String backTohome() {
		return "Home";
	}

	@RequestMapping("/book/delete")
	public String deleteMyBook(@RequestParam("bookId") int bookId, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		bookmarkService.deleteMyBook(logginUser.getId(), bookId);

		return "redirect:/myBooks";
	}

	@RequestMapping("/movie/delete")
	public String deleteMyMovie(@RequestParam("movieId") int movieId, HttpSession session) {

		logginUser = (User) session.getAttribute("sessionUser");

		bookmarkService.deleteMyMovie(logginUser.getId(), movieId);

		return "redirect:/myMovies";
	}

}
