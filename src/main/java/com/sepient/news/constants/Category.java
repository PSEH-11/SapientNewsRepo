package com.sepient.news.constants;

public enum Category {

	Business("business");
	
	private String type;
	
	private Category(String type) {
		this.type = type;
	}
	
	public String getCategory() {
		
		return this.type;
	}
	
}
