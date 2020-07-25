package com.football.interfaces;

import com.football.bean.matches.MatchesResponse;

public interface GetMatchesInterface {

	public MatchesResponse fetchMatchesResponse(String URL);	
}
