package com.football.dao;

import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.bean.news.NewsResponse;
import com.football.interfaces.GetNewsInterface;

public class GetNewsDaoImpl implements GetNewsInterface {

	@Override
	public NewsResponse fetchNewsResponse(String q) {
		NewsResponse newsResponse1 = null;
		try {
			FileReader reader = new FileReader("data/application.properties");
			Properties p = new Properties();
			p.load(reader);
			ObjectMapper mapper = new ObjectMapper();
			String url = "https://newsapi.org/v2/everything";
			String charset = "UTF-8";  			
			String sortBy = "publishedAt";
			String apiKey = p.getProperty("NewsDataPassword");

			String query = String.format("sortBy=%s&q=%s&apiKey=%s", 
			    URLEncoder.encode(sortBy, charset), 
			     URLEncoder.encode(q, charset),
			     URLEncoder.encode(apiKey, charset));
			
			URLConnection connection = new URL(url + "?" + query).openConnection();
			InputStream response = connection.getInputStream();
			NewsResponse newsResponse= mapper.readValue(response, NewsResponse.class);
			return newsResponse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newsResponse1;
	}

}
