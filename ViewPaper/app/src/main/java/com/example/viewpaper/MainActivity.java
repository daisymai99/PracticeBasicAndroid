package com.example.viewpaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewPaper);
        TabLayout tabLayout = findViewById(R.id.tabLayout);



        Adapter adapter= new Adapter(getSupportFragmentManager());
        adapter.add(new Log_in_Fragment(),"Log In");
        adapter.add(new Sign_Up_Fragment(),"Sign up");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}