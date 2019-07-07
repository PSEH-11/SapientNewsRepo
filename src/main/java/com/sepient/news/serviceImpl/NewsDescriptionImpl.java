package com.sepient.news.serviceImpl;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sepient.news.bean.Article;
import com.sepient.news.bean.NewsBean;
import com.sepient.news.bean.ResponseBean;
import com.sepient.news.constants.Category;
import com.sepient.news.service.NewsDescriptionI;

@Service
public class NewsDescriptionImpl implements NewsDescriptionI{
	
	@Autowired
	NewsRestClient newsRestClient;
	
	@Override
	public NewsBean getContent(String category, String country, String keyword) {
	
		List<Article> articles= newsRestClient.getApiData(country, category);
		NewsBean newsBean =filter(keyword, new ResponseBean());
		newsBean.setCountry(country);
		newsBean.setCategory(category);
		newsBean.setKeyword(keyword);
		return newsBean;
		
	}
	
	
	private NewsBean filter(String filter, ResponseBean responseBean) {
		
		List<Article> articles = responseBean.getArticles();
		
		NewsBean newsBean = new NewsBean();
		for(Article article: articles) {
			if(article.getTitle().contains(filter)) {
				newsBean.setTitle(article.getTitle());
				newsBean.setDescription(article.getContent());
			}
			break;
		}
		
		return newsBean;
		
	}



}
