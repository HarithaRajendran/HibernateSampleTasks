package com.asahi.thrillio.entity;


public class FilterBooksEntity {
	
	private String name;
	
	private String filteringOptions;
	
	public FilterBooksEntity() {
		
	}
	
	
	public String getFilteringOptions() {
		return filteringOptions;
	}


	public void setFilteringOptions(String filteringOptions) {
		this.filteringOptions = filteringOptions;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "FilterBooksEntity [name=" + name + ", filteringOptions=" + filteringOptions + "]";
	}
	
}
