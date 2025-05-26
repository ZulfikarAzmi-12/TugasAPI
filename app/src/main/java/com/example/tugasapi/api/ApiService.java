package com.example.tugasapi.api;

import com.example.tugasapi.model.TeamsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("search_all_teams.php")
    Call<TeamsResponse> getAllTeams(@Query("l") String league);

    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamsResponse> getAllSpain(@Query("l") String league);
}