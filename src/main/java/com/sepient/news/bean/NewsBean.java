package com.sepient.news.bean;

public class NewsBean {

	private String country;
	private String category;
	private String title;
	private String keyword;
	private String description;
	private String source;
	
	
	public NewsBean() {
		
	}
	
	public NewsBean(String country, String category, String title, String keyword, String description, String source) {
		super();
		this.country = country;
		this.category = category;
		this.title = title;
		this.keyword = keyword;
		this.description = description;
		this.source = source;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	
	
}
