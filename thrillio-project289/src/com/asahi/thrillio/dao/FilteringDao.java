package com.asahi.thrillio.dao;

import java.util.List;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.FilterBooksEntity;

public interface FilteringDao {
	
	public List<Book> filteredBooks(FilterBooksEntity filteredBooks);

}
