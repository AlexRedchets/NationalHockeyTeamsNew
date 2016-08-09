package com.azvk.nationalhockeyteams.client;

import com.azvk.nationalhockeyteams.models.Team;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface TeamClient {
    @GET("api/player/{team}")
    Observable<List<Team>> teams(
            @Path("team") String team
    );
}