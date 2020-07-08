package com.football.json.demo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private Competition competition;
	private List<Standings> standings;

	public Response() {

	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Standings> getStandings() {
		return standings;
	}

	public void setStandings(ArrayList<Standings> standings) {
		this.standings = standings;
	}

}
