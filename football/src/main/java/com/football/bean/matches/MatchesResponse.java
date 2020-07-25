package com.football.bean.matches;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchesResponse {
	private int count;
	private List<Matches> matches;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Matches> getMatches() {
		return matches;
	}

	public void setMatches(List<Matches> matches) {
		this.matches = matches;
	}

}
