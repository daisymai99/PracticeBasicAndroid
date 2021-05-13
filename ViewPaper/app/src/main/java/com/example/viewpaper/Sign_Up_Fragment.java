package com.example.viewpaper;

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

public class Sign_Up_Fragment extends Fragment {

    float n=0;
    EditText email, mobile,pass,confirm ;
    Button sign ;
    TabLayout tabLayout;

    public Sign_Up_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.sign_up,container,false);

        email = view.findViewById(R.id.Email);
        pass = view.findViewById(R.id.Password);
        mobile = view.findViewById(R.id.Mobile);
        confirm = view.findViewById(R.id.Confirm);
        sign = view.findViewById(R.id.sign);

        email.setTranslationX(300);
        pass.setTranslationX(300);
        mobile.setTranslationX(300);
        confirm.setTranslationX(300);
        confirm.setTranslationX(300);

        email.setAlpha(n);
        mobile.setAlpha(n);
        pass.setAlpha(n);
        confirm.setAlpha(n);
        sign.setAlpha(n);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        mobile.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        confirm.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        sign.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
