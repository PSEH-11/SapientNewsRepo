package com.sepient.news.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
	
	
	/*method for filtering articles on the basis of the keyword*/
	
	private NewsBean filter(String filter, List<Article> articles) {
		NewsBean newsBean = new NewsBean();
		if(!CollectionUtils.isEmpty(articles)) {
			for(Article article: articles) {
				if(article.getTitle().contains(filter)) {
					newsBean.setTitle(article.getTitle());
					newsBean.setDescription(article.getContent());
					return newsBean;
				}
				else if(article.getDescription().contains(filter)) {
					newsBean.setTitle(article.getTitle());
					newsBean.setDescription(article.getContent());
					return newsBean;
				}
			}
		}
		
		return newsBean;
		
	}



}
