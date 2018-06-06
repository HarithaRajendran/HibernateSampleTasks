package com.asahi.thrillio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asahi.thrillio.dao.FilteringDao;
import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.FilterBooksEntity;

@Service
public class FilteringServiceClass implements FilteringService{
	
	@Autowired
	private FilteringDao filteringDao;

	@Override
	@Transactional
	public List<Book> filteredBooks(FilterBooksEntity filteredBooks) {
		
		List<Book> filteredBooksBy = filteringDao.filteredBooks(filteredBooks);
		
		return filteredBooksBy;
	}

}
