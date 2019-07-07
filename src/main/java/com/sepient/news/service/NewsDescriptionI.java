package com.sepient.news.service;

import com.sepient.news.bean.NewsBean;

public interface NewsDescriptionI {

	NewsBean getContent(String category, String country, String filter);
}
