package com.football.bean.standings;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Standings {
	private String type;
	private List<Table> table;

	public Standings() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Table> getTable() {
		return table;
	}

	public void setTable(ArrayList<Table> table) {
		this.table = table;
	}

}
