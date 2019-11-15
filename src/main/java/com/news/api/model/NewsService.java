package com.news.api.model;

import java.util.List;

public interface NewsService {
	public List<NewsFeedWrapper> getNews();
}
