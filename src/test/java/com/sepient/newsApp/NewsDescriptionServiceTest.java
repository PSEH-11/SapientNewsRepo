package com.sepient.newsApp;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.sepient.news.bean.Article;
import com.sepient.news.bean.NewsBean;
import com.sepient.news.serviceImpl.NewsDescriptionImpl;
import com.sepient.news.serviceImpl.NewsRestClient;

@RunWith(MockitoJUnitRunner.class)
public class NewsDescriptionServiceTest {
	
	@InjectMocks
	private NewsDescriptionImpl impl;
	
	@Mock
	NewsRestClient restClient;
	
	NewsBean newsBean;
	
	List<Article> articleList= new ArrayList<>();;
	
	@Test
	public void testFilterNews() {
	
		String category = "business";
		String country = "us";
		String keyword = "some";
		NewsBean newsBean = impl.getContent(category, country, keyword);
		when(restClient.getApiData("us", "business")).thenReturn(articleList);
		assertNotNull(newsBean);
		Mockito.verify(newsBean).getCategory().equals("business");
	}
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
}
