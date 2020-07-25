package com.football.bean.news;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsResponse {

	private List<Articles> articles;

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Articles> articles) {
		this.articles = articles;
	}

}
