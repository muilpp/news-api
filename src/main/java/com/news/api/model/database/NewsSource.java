package com.news.api.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class NewsSource {

	@Id
	@GeneratedValue
	private Long Id;

	private String url;
	private String name;
	
	public NewsSource() {}

	public NewsSource(String url, String name) {
		this.url = url;
		this.name = name;
	}
}