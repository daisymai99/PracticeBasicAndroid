package com.example.android.retrofit;

import com.example.android.model.MovieExample;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {




    @GET("movie/popular")
    Call<MovieExample> getDataMovie(@Query("api_key") String api_key);

}
