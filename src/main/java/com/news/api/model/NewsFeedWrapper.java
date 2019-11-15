package com.news.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsFeedWrapper {

	private String newsFeedSource;
	private List<NewsFeed> newsFeedList;
	
	public NewsFeedWrapper() {}
}
