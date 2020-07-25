package com.football.interfaces;

import com.football.bean.news.NewsResponse;

public interface GetNewsInterface {

	public NewsResponse fetchNewsResponse(String q);
}
