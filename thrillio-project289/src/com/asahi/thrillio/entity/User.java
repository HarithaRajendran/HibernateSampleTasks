package com.asahi.thrillio.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	public User() {
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
}


























//public List<Book> getBooks() {
//return books;
//}
//
//public void setBooks(List<Book> books) {
//this.books = books;
//}
//
//public List<Movie> getMovies() {
//return movies;
//}
//
//public void setMovies(List<Movie> movies) {
//this.movies = movies;
//}
//
//public void addMovie(Movie movie) {
////	if (movies == null) {
//		
//		System.out.println("nullllll");
//		movies = new ArrayList<>();
////	}
//
//		movies.add(movie);
//}
//
//public void addBook(Book book) {
////	if (books == null) {
//		
//		System.out.println("nullllll");
//		books = new ArrayList<>();
////	}
//
//		books.add(book);
//}


//@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
//CascadeType.REFRESH })
//@JoinTable(name = "book_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
//private List<Book> books;
//
//@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
//CascadeType.REFRESH })
//@JoinTable(name = "movie_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
//private List<Movie> movies;