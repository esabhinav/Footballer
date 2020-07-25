package com.football.springboot.football.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.football.bean.matches.Matches;
import com.football.bean.matches.MatchesResponse;
import com.football.bean.news.Articles;
import com.football.bean.news.NewsResponse;
import com.football.bean.standings.Competition;
import com.football.bean.standings.StandingsResponse;
import com.football.bean.standings.Table;
import com.football.bean.stats.Scorers;
import com.football.bean.stats.StatsResponse;
import com.football.bean.team.Team;
import com.football.bean.team.TeamResponse;
import com.football.dao.GetMatchesDaoImpl;
import com.football.dao.GetNewsDaoImpl;
import com.football.dao.GetStandingsDaoImpl;
import com.football.dao.GetStatsDaoImpl;

@Controller
public class FootballController {
	
	@GetMapping("/")
	public String index(Model theModel){
		GetNewsDaoImpl getNewsDaoImpl = new GetNewsDaoImpl();
		NewsResponse newsResponse = getNewsDaoImpl.fetchNewsResponse("Football");
		List<Articles> articles = newsResponse.getArticles();
		theModel.addAttribute("news", articles);
		return "index";
	}
	
	@GetMapping("/football/home")
	public String home(Model theModel){
		GetNewsDaoImpl getNewsDaoImpl = new GetNewsDaoImpl();
		NewsResponse newsResponse = getNewsDaoImpl.fetchNewsResponse("Football");
		List<Articles> articles = newsResponse.getArticles();
		theModel.addAttribute("news", articles);
		return "index";
	}
	
	@GetMapping("/football/LaLiga")
	public String LaLigaStandings(Model theModel) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			GetStandingsDaoImpl standingsResponse = new GetStandingsDaoImpl();
			String URL = "http://api.football-data.org/v2/competitions/PD/standings";
			StandingsResponse standresponse = standingsResponse.fetchStandingsResponse(URL);
			Competition competition = standresponse.getCompetition();
			List<Table> table = standingsResponse.fetchTable(standresponse);
			GetStatsDaoImpl statResponse = new GetStatsDaoImpl();
			URL = "http://api.football-data.org/v2/competitions/PD/scorers?limit=25";
			StatsResponse statsResponse = statResponse.fetchStatsResponse(URL);
			GetMatchesDaoImpl matchesResponse = new GetMatchesDaoImpl();
			URL = "http://api.football-data.org/v2/competitions/PD/matches?status=SCHEDULED";
			MatchesResponse matchResponse = matchesResponse.fetchMatchesResponse(URL);
			GetNewsDaoImpl getNewsDaoImpl = new GetNewsDaoImpl();
			NewsResponse newsResponse = getNewsDaoImpl.fetchNewsResponse("La Liga");
/*			NewsResponse newsResponse = mapper.readValue(new File("data/NewsFinal.json"), NewsResponse.class);*/
			TeamResponse teamResponse = mapper.readValue(new File("data/teams.json"), TeamResponse.class);
			List<Scorers> scorers = statsResponse.getScorers();
			if (matchResponse.getCount() != 0) {
				List<Matches> matches = matchResponse.getMatches();
				theModel.addAttribute("matches", matches);
			}
			List<Articles> articles = newsResponse.getArticles();
			HashMap<String, String> teams = new HashMap<>();
			for (Team team : teamResponse.getTeams()) {
				teams.put(team.getName(), team.getCrestUrl());
			}
			theModel.addAttribute("competition", competition);
			theModel.addAttribute("news", articles);
			theModel.addAttribute("scorers", scorers);
			theModel.addAttribute("teams", teams);

			theModel.addAttribute("table", table);
			return "list-standings-PD";
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/football/PremierLeague")
	public String PLStandings(Model theModel) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			GetStandingsDaoImpl standingsResponse = new GetStandingsDaoImpl();
			String URL = "http://api.football-data.org/v2/competitions/PL/standings";
			StandingsResponse standresponse = standingsResponse.fetchStandingsResponse(URL);
			Competition competition = standresponse.getCompetition();
			List<Table> table = standingsResponse.fetchTable(standresponse);
			GetStatsDaoImpl statResponse = new GetStatsDaoImpl();
			URL = "http://api.football-data.org/v2/competitions/PL/scorers?limit=25";
			StatsResponse statsResponse = statResponse.fetchStatsResponse(URL);
			GetMatchesDaoImpl matchesResponse = new GetMatchesDaoImpl();
			URL = "http://api.football-data.org/v2/competitions/PL/matches?status=SCHEDULED";
			MatchesResponse matchResponse = matchesResponse.fetchMatchesResponse(URL);
			GetNewsDaoImpl getNewsDaoImpl = new GetNewsDaoImpl();
			NewsResponse newsResponse = getNewsDaoImpl.fetchNewsResponse("Premier League");
			//NewsResponse newsResponse = mapper.readValue(new File("data/PLNews.json"), NewsResponse.class);
			TeamResponse teamResponse = mapper.readValue(new File("data/PLTeams.json"), TeamResponse.class);
			List<Scorers> scorers = statsResponse.getScorers();
			if (matchResponse.getCount() != 0) {
				List<Matches> matches = matchResponse.getMatches();
				theModel.addAttribute("matches", matches);
			}
			List<Articles> articles = newsResponse.getArticles();
			HashMap<String, String> teams = new HashMap<>();
			for (Team team : teamResponse.getTeams()) {
				teams.put(team.getName(), team.getCrestUrl());
			}
			theModel.addAttribute("competition", competition);
			theModel.addAttribute("news", articles);
			theModel.addAttribute("scorers", scorers);
			theModel.addAttribute("teams", teams);

			theModel.addAttribute("table", table);
			return "list-standings-PL";
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}

}
