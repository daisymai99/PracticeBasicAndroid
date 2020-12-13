package com.example.practicelivedataviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends  AppCompatActivity {
    private List<String> mSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listShow);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
        MainActivityViewModel model = new ViewModelProvider(this).get(MainActivityViewModel.class);

         final Observer<List<String>> songObserver = new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1, android.R.id.text1,strings);
                listView.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            }
        };
        model.getSongList().observe(this,songObserver);
    }

}


