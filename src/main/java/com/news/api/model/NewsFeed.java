package com.news.api.model;

import java.util.Date;

import com.rometools.rome.feed.synd.SyndEntry;

import lombok.Data;

@Data
public class NewsFeed {

	private String title, link, description, imgUrl;
	private Date publishedDate;

	public NewsFeed() {}

	public NewsFeed (SyndEntry feed) {
		this.title = feed.getTitle();
		this.link = feed.getLink();
		this.description = feed.getDescription().getValue();
		this.publishedDate = feed.getPublishedDate();
		this.imgUrl = feed.getEnclosures().isEmpty() ? null : feed.getEnclosures().get(0).getUrl();
	}
}
