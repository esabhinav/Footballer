package com.football.bean.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
	private int id;
	private String name;
	private String crestUrl;

	public Team() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCrestUrl() {
		return crestUrl;
	}

	public void setCrestUrl(String crestUrl) {
		this.crestUrl = crestUrl;
	}

}
