package com.football.dao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.io.*;
import com.football.bean.matches.MatchesResponse;
import com.football.interfaces.GetMatchesInterface;

public class GetMatchesDaoImpl implements GetMatchesInterface {

	@Override
	public MatchesResponse fetchMatchesResponse(String URL) {
		MatchesResponse theResponse = new MatchesResponse();
		try {
			FileReader reader = new FileReader("data/application.properties");
			Properties p = new Properties();
			p.load(reader);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set(p.getProperty("footballDataUser"), p.getProperty("footballDataPassword"));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<MatchesResponse> respEntity = restTemplate.exchange(URL, HttpMethod.GET, entity,
					MatchesResponse.class);
			theResponse = respEntity.getBody();
			return theResponse;
		} catch (Exception e) {
			return theResponse;
		}
	}
}
