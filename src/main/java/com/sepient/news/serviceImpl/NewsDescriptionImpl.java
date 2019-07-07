package com.sepient.news.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sepient.news.bean.Article;
import com.sepient.news.bean.NewsBean;
import com.sepient.news.service.NewsDescriptionI;

@Service
public class NewsDescriptionImpl implements NewsDescriptionI{
	
	@Autowired
	NewsRestClient newsRestClient;
	
	@Override
	public NewsBean getContent(String category, String country, String keyword) {
	
		List<Article> articles= newsRestClient.getApiData(country, category);
		NewsBean newsBean =filter(keyword, articles);
		newsBean.setCountry(country);
		newsBean.setCategory(category);
		newsBean.setKeyword(keyword);
		return newsBean;
		
	}
	
	
	private NewsBean filter(String filter, List<Article> articles) {
		
		NewsBean newsBean = new NewsBean();
		for(Article article: articles) {
			if(article.getTitle().contains(filter)) {
				newsBean.setTitle(article.getTitle());
				newsBean.setDescription(article.getContent());
				break;
			}
			else if(article.getDescription().contains(filter)) {
				newsBean.setTitle(article.getTitle());
				newsBean.setDescription(article.getContent());
				break;
			}
		}
		
		return newsBean;
		
	}



}
