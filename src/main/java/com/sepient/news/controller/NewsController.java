package com.sepient.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sepient.news.bean.NewsBean;
import com.sepient.news.service.NewsDescriptionI;

@RestController
@RequestMapping("/headline")
public class NewsController {
	
	@Autowired
	NewsDescriptionI newsDescriptionI;

	@GetMapping
	ResponseEntity<?> getNews(@RequestParam(value = "category")  String category,
			@RequestParam(value = "country")  String country, @RequestParam(value = "country")  String filter){
		NewsBean newsBean = newsDescriptionI.getContent(category, country, filter);
		return new ResponseEntity<NewsBean>(newsBean, HttpStatus.OK);
	}
}
