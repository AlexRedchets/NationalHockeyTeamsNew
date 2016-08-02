package com.azvk.nationalhockeyteams.client;

import com.azvk.nationalhockeyteams.models.Rosters;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface RostersClient {

    @GET("api/player/{team}")
    Observable<List<Rosters>> rosters(
            @Path("team") String team
    );
}
