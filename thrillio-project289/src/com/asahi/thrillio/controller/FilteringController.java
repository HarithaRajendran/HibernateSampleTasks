package com.asahi.thrillio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.asahi.thrillio.entity.Book;
import com.asahi.thrillio.entity.FilterBooksEntity;
import com.asahi.thrillio.service.FilteringService;


@Controller
public class FilteringController {
	
	@Autowired
	private FilteringService filteringService;
	

	@Value("#{filteringOptions}")
	private Map<String,String> filteringOptions;
	
	@PostMapping("/filterBooks/books")
	public String showFilteredBooks(@ModelAttribute("toFilter") FilterBooksEntity filteredBooks,Model model) {
		
		List<Book> filteredBooksBy = filteringService.filteredBooks(filteredBooks);
		
		if(filteredBooksBy.equals(null)) {
			return "No-books";
		}else {
			model.addAttribute("filteredBooksBy",filteredBooksBy);
			return "filter-books";
		}
	}

}
