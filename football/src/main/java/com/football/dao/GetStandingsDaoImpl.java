package com.football.dao;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.football.bean.standings.StandingsResponse;
import com.football.bean.standings.Table;
import com.football.interfaces.GetStandingsInterface;

public class GetStandingsDaoImpl implements GetStandingsInterface {

	@Override
	public StandingsResponse fetchStandingsResponse(String URL) {
		StandingsResponse theResponse = null;

		try {
			FileReader reader = new FileReader("data/application.properties");
			Properties p = new Properties();
			p.load(reader);
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set(p.getProperty("footballDataUser"), p.getProperty("footballDataPassword"));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<StandingsResponse> respEntity = restTemplate.exchange(URL, HttpMethod.GET, entity,
					StandingsResponse.class);
			theResponse = respEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return theResponse;
	}

	@Override
	public List<Table> fetchTable(StandingsResponse response) {
		return response.getStandings().get(0).getTable();
	}
}
