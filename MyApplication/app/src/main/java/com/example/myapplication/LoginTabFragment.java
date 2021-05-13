package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class LoginTabFragment extends Fragment {

    float n=0;
    EditText email , pass ;
    TextView forgot ;
    Button login;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login,container,false);

        email =(EditText) root.findViewById(R.id.Email);
        pass = (EditText)root.findViewById(R.id.Password);
        forgot = root.findViewById(R.id.forgot);
        login = root.findViewById(R.id.login);

        email.setTranslationX(300);
        pass.setTranslationX(300);
        forgot.setTranslationX(300);
        login.setTranslationX(300);

        email.setAlpha(n);
        pass.setAlpha(n);
        forgot.setAlpha(n);
        login.setAlpha(n);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        forgot.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();

        return  root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
//        tabLayout.setupWithViewPager(viewPager);
//    }
}
