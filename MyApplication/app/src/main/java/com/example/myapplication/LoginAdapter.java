package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;
public class LoginAdapter  extends FragmentPagerAdapter {

//    private final Context context;
    int totalTab;
    private String[] tabTitles = new String[]{"Log In", "Sign Up"};
    private final List<Fragment> fragments = new ArrayList<>();

    public LoginAdapter(FragmentManager fm  ){
        super(fm);
    }


    @Override
    public int getCount() {

        return 2;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    public void add(Fragment fragment) {
        fragments.add(fragment);

    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
