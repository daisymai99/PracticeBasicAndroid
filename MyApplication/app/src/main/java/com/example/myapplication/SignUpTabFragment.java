package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class SignUpTabFragment extends Fragment {

    EditText email, mobile,pass,confirm ;
    ViewPager viewPager;
    Button sign ;
    float n =0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.sign_up,container,false);

        email = root.findViewById(R.id.Email);
        pass = root.findViewById(R.id.Password);
        mobile = root.findViewById(R.id.Mobile);
        confirm = root.findViewById(R.id.Confirm);

        email.setTranslationX(300);
        pass.setTranslationX(300);
        mobile.setTranslationX(300);
        confirm.setTranslationX(300);

        email.setAlpha(n);
        mobile.setAlpha(n);
        pass.setAlpha(n);
        confirm.setAlpha(n);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        mobile.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        confirm.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        sign.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        return  root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        LoginAdapter loginAdapter = new LoginAdapter(getChildFragmentManager());
//        viewPager = view.findViewById(R.id.viewPaper);
//        viewPager.setAdapter(loginAdapter);
//    }
}
