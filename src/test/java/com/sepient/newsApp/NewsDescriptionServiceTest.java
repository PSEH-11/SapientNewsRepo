package com.sepient.newsApp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	
	
	/*tests for the availability of the keyword*/
	@Test
	public void testFilterNewsWithContentAvailable() {
	
		String category = "business";
		String country = "us";
		String keyword = "test";
		when(restClient.getApiData(Mockito.anyString(), Mockito.anyString())).thenReturn(articleList);
		NewsBean newsBean = impl.getContent(category, country, keyword);
		assertNotNull(newsBean);
		assertNotNull(newsBean.getDescription());
	}
	
	
	/*tests when keyword is not found in the news items*/
	@Test
	public void testFilterNewsWithContentUnAvailable() {
	
		String category = "business";
		String country = "us";
		String keyword = "123";
		NewsBean newsBean = impl.getContent(category, country, keyword);
		when(restClient.getApiData(Mockito.anyString(), Mockito.anyString())).thenReturn(articleList);
		assertNotNull(newsBean);
		assertNull(newsBean.getDescription());
	}
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	    
	    Article article = new Article();
	    article.setContent("some-content");
	    article.setDescription("test-description");
	    article.setTitle("test-title test");
	    articleList.add(article);
	}
	
}
