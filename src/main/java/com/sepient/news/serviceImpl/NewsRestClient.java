package com.sepient.news.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sepient.news.bean.Article;

@Service
public class NewsRestClient {

	@Value("${api.key}")
	String apiKey;
	
	
	/*
	 * makes rest call to News API for fetching the content
	 *
	 */
	
	public List<Article> getApiData(String country, String category) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		
		Map<String, String> params = new HashMap<>();
		params.put("country", country);
		params.put("category", category);
		params.put("apiKey", apiKey);
		
		ResponseEntity<List<Article>> res= restTemplate.exchange("https://newsapi.org/v2/top-headlines?country={country}&category={category}&apiKey={apiKey}", HttpMethod.GET, entity, new ParameterizedTypeReference<List<Article>>() {
		}, params);
		return res.getBody();
				
	}
}
