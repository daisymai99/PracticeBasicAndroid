package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout  tab;
    ViewPager viewPager;
    FloatingActionButton fb,twitter , google;
    float n =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPaper);
        tab = findViewById(R.id.tabLayout);


        // set the adapter
        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager());
        adapter.add(new LoginTabFragment());
        adapter.add(new SignUpTabFragment());
        viewPager.setAdapter(adapter);


        tab.setTabGravity(TabLayout.GRAVITY_FILL); // tab name fill parent

        // link tabLayout with ViewPager
        tab.setupWithViewPager(viewPager);





        // animation
        fb= (FloatingActionButton) findViewById(R.id.fb);
        google= (FloatingActionButton) findViewById(R.id.google);
        twitter= (FloatingActionButton)findViewById(R.id.twitter);
        fb.setTranslationX(300);
        google.setTranslationX(300);
        twitter.setTranslationX(300);

        fb.setAlpha(n);
        google.setAlpha(n);
        twitter.setAlpha(n);
        tab.setAlpha(n);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tab.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
    }
}