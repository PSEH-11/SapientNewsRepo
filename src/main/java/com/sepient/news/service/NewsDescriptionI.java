package com.sepient.news.service;

import com.sepient.news.bean.NewsBean;
import com.sepient.news.constants.Category;

public interface NewsDescriptionI {

	NewsBean getContent(String category, String country, String filter);
}
