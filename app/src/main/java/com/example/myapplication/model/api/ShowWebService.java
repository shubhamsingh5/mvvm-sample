package com.example.myapplication.model.api;

import com.example.myapplication.model.Show;
import com.example.myapplication.model.ShowResultsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShowWebService {
    @GET("/?apikey=8158108")
    Call<ShowResultsList> getSearchResults(@Query("s") String query);

    @GET("/?apikey=8158108")
    Call<Show> getShowById(@Query("t") int imdbId);
}
