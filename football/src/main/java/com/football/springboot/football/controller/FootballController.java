package com.football.springboot.football.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.football.json.demo.Competition;
import com.football.json.demo.Response;
import com.football.json.demo.Standings;
import com.football.json.demo.Table;

@Controller
@RequestMapping("/football")
public class FootballController {

	@GetMapping("/list")
	public String listStandings(Model theModel) {
		try {
			Standings standings;
			Competition competition;
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-Auth-Token", "49b687247e9b41dd95d0a76faf2926b0");
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<Response> respEntity = restTemplate.exchange(
					"http://api.football-data.org/v2/competitions/PD/standings", HttpMethod.GET, entity,
					Response.class);
			Response theResponse = respEntity.getBody();
			System.out.println(theResponse.getCompetition().getName());

			competition = theResponse.getCompetition();
			standings = theResponse.getStandings().get(0);

			theModel.addAttribute("competition", competition);
			theModel.addAttribute("standings", standings);

			List<Table> table = standings.getTable();

			theModel.addAttribute("table", table);

			return "list-standings";
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}

}
