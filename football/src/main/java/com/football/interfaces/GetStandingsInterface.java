package com.football.interfaces;

import java.util.List;

import com.football.bean.standings.StandingsResponse;
import com.football.bean.standings.Table;

public interface GetStandingsInterface {

	public StandingsResponse fetchStandingsResponse(String URL);
	
	public List<Table> fetchTable(StandingsResponse response);
}
