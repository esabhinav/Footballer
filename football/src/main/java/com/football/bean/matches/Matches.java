package com.football.bean.matches;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.football.bean.team.Team;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Matches {

	private String utcDate;
	private String startDate;
	private String startTime;
	private Team homeTeam;
	private Team awayTeam;
	private int matchday;


	public String getStartDate() {
		setStartDate(utcDate);
		return startDate;
	}

	public void setStartDate(String startDate) {
		try {
			startDate=startDate.substring(0, 10);
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			startDate = dateFormat.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.startDate = startDate;
	}

	public String getStartTime() {
		setStartTime(utcDate);
		return startTime;
	}

	public void setStartTime(String startTime) {
		try {
			startTime=startTime.substring(11, 19);
			Date date1 = new SimpleDateFormat("HH:mm:ss").parse(startTime);
			DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
			startTime = dateFormat.format(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.startTime = startTime;
	}
	
	public int getMatchday() {
		return matchday;
	}

	public void setMatchday(int matchday) {
		this.matchday = matchday;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getUtcDate() {
		return utcDate;
	}

	public void setUtcDate(String utcDate) {
		this.utcDate = utcDate;
	}

}
