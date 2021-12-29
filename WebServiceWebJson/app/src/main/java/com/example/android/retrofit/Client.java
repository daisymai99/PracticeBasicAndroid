package com.example.android.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    public static final String BASE_URL = "https://dongabank.com.vn/";

    public static final String testUrl = "https://api.themoviedb.org/3/";



    public static Retrofit retrofit = null;

    public static Retrofit getclient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }


    
    public static Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(testUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }



}
