package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.android.adapter.AdapterListMovie;

import com.example.android.model.MovieExample;
import com.example.android.model.Result;
import com.example.android.retrofit.Client;
import com.example.android.retrofit.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitCall extends AppCompatActivity {
    ListView listView;
    
    final String API_KEY="cbd41d05314adcd66369942fe63ab586";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_call);

        listView = findViewById(R.id.listView);
        loadMovie();

    }

    public void loadMovie(){
        Client client = new Client();
        Service service = client.getRetrofit().create(Service.class);

        Call<MovieExample> call = service.getDataMovie(API_KEY);

        call.enqueue(new Callback<MovieExample>() {
            @Override
            public void onResponse(Call<MovieExample> call, Response<MovieExample> response) {
                MovieExample movieExample= response.body();
                List<Result> list = movieExample.getResults();
                AdapterListMovie adapterListMovie = new AdapterListMovie(RetrofitCall.this,R.layout.item_movie,list);
                listView.setAdapter(adapterListMovie);

            }

            @Override
            public void onFailure(Call<MovieExample> call, Throwable t) {

            }
        });
    }
}