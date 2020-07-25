package com.tester;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			HttpHeaders headers = new HttpHeaders();
			ObjectMapper mapper = new ObjectMapper();
			String url = "https://newsapi.org/v2/everything";
			String charset = "UTF-8";  			
			String sortBy = "publishedAt";
			String q = "premier league";
			String apiKey = "6283825f5fdc4300842085e3146e5074";

			String query = String.format("sortBy=%s&q=%s&apiKey=%s", 
			    URLEncoder.encode(sortBy, charset), 
			     URLEncoder.encode(q, charset),
			     URLEncoder.encode(apiKey, charset));
			
			URLConnection connection = new URL(url + "?" + query).openConnection();
			InputStream response = connection.getInputStream();
			NewsResponse newsResponse1= mapper.readValue(response, NewsResponse.class);
			System.out.println(newsResponse1.getArticles().get(0).getUrl());
		} catch (Exception exp) {
			exp.printStackTrace();
		}

	}

}
