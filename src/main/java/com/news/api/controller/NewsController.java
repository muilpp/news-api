package com.news.api.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.api.model.NewsFeedWrapper;
import com.news.api.model.NewsService;

@RestController
@RequestMapping("/")
public class NewsController {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(NewsController.class.getName());

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public List<NewsFeedWrapper> getFeeds() {
		return newsService.getNews();
	}
}