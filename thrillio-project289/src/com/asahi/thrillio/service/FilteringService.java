package com.asahi.thrillio.service;

import java.util.List;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.FilterBooksEntity;

public interface FilteringService {
	public List<Book> filteredBooks(FilterBooksEntity filteredBooks);
}
