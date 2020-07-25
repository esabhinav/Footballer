package com.football.dao;

import java.io.FileReader;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.football.bean.stats.StatsResponse;
import com.football.interfaces.GetStatsInterface;

public class GetStatsDaoImpl implements GetStatsInterface {

	@Override
	public StatsResponse fetchStatsResponse(String URL) {
		StatsResponse theResponse = null;
		try {
			FileReader reader = new FileReader("data/application.properties");
			Properties p = new Properties();
			p.load(reader);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set(p.getProperty("footballDataUser"), p.getProperty("footballDataPassword"));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<StatsResponse> respEntity = restTemplate.exchange(URL, HttpMethod.GET, entity,
					StatsResponse.class);
			theResponse = respEntity.getBody();
			return theResponse;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return theResponse;
	}
}
