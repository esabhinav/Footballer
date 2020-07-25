package com.football.interfaces;

import com.football.bean.stats.StatsResponse;

public interface GetStatsInterface {

	public StatsResponse fetchStatsResponse(String URL);	
}
