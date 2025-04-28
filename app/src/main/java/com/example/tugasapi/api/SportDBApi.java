package com.example.tugasapi.api;

import com.example.tugasapi.model.TeamsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SportDBApi {
    @GET("search_all_teams.php")
    Call<TeamsResponse> getAllTeams(@Query("l") String league);
}