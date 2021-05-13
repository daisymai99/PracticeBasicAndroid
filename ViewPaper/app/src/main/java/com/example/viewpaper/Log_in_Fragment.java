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

public class Log_in_Fragment extends Fragment {


    EditText email , pass ;
    TextView forgot ;
    Button login;
    float n=0;

    public Log_in_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.login_tab,container,false);

        email =(EditText) view.findViewById(R.id.Email);
        pass = (EditText)view.findViewById(R.id.Password);
        forgot = view.findViewById(R.id.forgot);
        login = view.findViewById(R.id.login);


        email.setTranslationX(300);
        pass.setTranslationX(300);
        forgot.setTranslationX(300);
        login.setTranslationX(300);


        email.setAlpha(n);
        forgot.setAlpha(n);
        pass.setAlpha(n);
        login.setAlpha(n);


        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        forgot.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
