package com.football.bean.stats;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatsResponse {

	private int count;
	private Competition competition;
	private List<Scorers> scorers;

	public StatsResponse() {

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Competition getCompetition() {
		return competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public List<Scorers> getScorers() {
		return scorers;
	}

	public void setScorers(ArrayList<Scorers> scorers) {
		this.scorers = scorers;
	}

}