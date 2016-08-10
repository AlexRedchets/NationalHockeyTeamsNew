package com.azvk.nationalhockeyteams.client;

import com.azvk.nationalhockeyteams.models.User;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface UserClient {

    @POST("api/login")
    Observable<Boolean> userLogin(@Body User user);

    @POST("api/registration")
    Observable<String> userRegistration(@Body User user);
}
