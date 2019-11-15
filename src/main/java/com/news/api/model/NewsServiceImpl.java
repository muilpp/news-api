package com.news.api.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.news.api.model.database.NewsSource;
import com.news.api.model.database.NewsSourceRepository;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

@Service
public class NewsServiceImpl implements NewsService{

	private static final Logger LOGGER = Logger.getLogger(NewsServiceImpl.class.getName());

	@Autowired
	private NewsSourceRepository newsRepo;

	@Override
	public List<NewsFeedWrapper> getNews() {
		List<NewsSource> newsSourceList = newsRepo.findAll();
		List<NewsFeed> newsFeedResponseList = new ArrayList<>();
		NewsFeedWrapper newsFeedWrapper = new NewsFeedWrapper();
		List<NewsFeedWrapper> newsFeedWrapperList = new ArrayList<>();

		for (NewsSource newsSource : newsSourceList) {
			newsFeedWrapper.setNewsFeedSource(newsSource.getName());

			try {
				URL feedSource = new URL(newsSource.getUrl());
				SyndFeedInput input = new SyndFeedInput();
				SyndFeed feed = input.build(new XmlReader(feedSource));

				if (!feed.getEntries().isEmpty())
					feed.getEntries().stream().map(x -> new NewsFeed(x)).forEach(x -> newsFeedResponseList.add(x));

				newsFeedWrapper.setNewsFeedList(new ArrayList<>(newsFeedResponseList));
				newsFeedWrapperList.add(newsFeedWrapper);
				newsFeedWrapper = new NewsFeedWrapper();
				newsFeedResponseList.clear();
			} catch (IllegalArgumentException | FeedException | IOException e) {
				LOGGER.log(Level.SEVERE, e.getMessage(), e);
			}
		}

		return newsFeedWrapperList;
	}
}