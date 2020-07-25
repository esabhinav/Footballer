package com.football.bean.stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.bean.team.Team;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Scorers {

	private Player player;
	private Team team;
	private int numberOfGoals;

	public Scorers(){
		
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getNumberOfGoals() {
		return numberOfGoals;
	}

	public void setNumberOfGoals(int numberOfGoals) {
		this.numberOfGoals = numberOfGoals;
	}

}
