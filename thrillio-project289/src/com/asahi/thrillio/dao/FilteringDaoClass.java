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
import com.asahi.thrillio.entity.FilterBooksEntity;
import com.asahi.thrillio.entity.Publisher;

@Repository
public class FilteringDaoClass implements FilteringDao {

	@Autowired
	private SessionFactory factory;

	
	@Override
	public List<Book> filteredBooks(FilterBooksEntity filteredBooks) {

		Session session = factory.getCurrentSession();
		
		Query<Book> query = session.createQuery("from Book",Book.class);
		
		
		List<Book> books = query.getResultList();
		

		List<Book> filteredBooksBy = new ArrayList<>();


		Query<Publisher> publishers = session.createQuery("from Publisher", Publisher.class);

		List<Publisher> allPublishers = publishers.getResultList();

		Integer publisherId = filterPublisher(allPublishers, filteredBooks.getName());
		
		System.out.println("publisherId "+publisherId);
		
		System.out.println("filteredBooks.getFilteringOptions() "+filteredBooks.getFilteringOptions());

		if ((filteredBooks.getFilteringOptions()).equals("publisher")) {
			
			for(Book book:books) {
				if((book.getPublisher().getId()).equals(publisherId)) {
					filteredBooksBy.add(book);
				}
			}
			return filteredBooksBy;
		
			
		} else if ((filteredBooks.getFilteringOptions()).equals("book_genre") ) {
			Query<Book> theQuery = session
					.createQuery("from Book where " + filteredBooks.getFilteringOptions() + "=:bookGenre", Book.class);

			theQuery.setParameter("bookGenre", filteredBooks.getName());

			filteredBooksBy = theQuery.getResultList();
			
		} else if((filteredBooks.getFilteringOptions()).equals("author")){
			System.out.println("gggggggggggg");
			Query<Book> theQuery = session
					.createQuery("from Book where " + filteredBooks.getFilteringOptions() + "=:author", Book.class);

			theQuery.setParameter("author", filteredBooks.getName());

			filteredBooksBy = theQuery.getResultList();

		}

		return filteredBooksBy;
	}

	private Integer filterPublisher(List<Publisher> allPublishers, String name) {

		Integer publisherId = null;

		List<Publisher> filteredData = allPublishers.stream().filter(data -> (data.getPublisherName().equals(name)))
				.collect(Collectors.toList());

		for (Publisher publisher : filteredData) {	
			
			System.out.println(publisher);
			
			System.out.println(publisher.getId());

			publisherId = publisher.getId();
		}

		return publisherId;
	}

}
