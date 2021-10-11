package com.example.assetsharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.assetsharedpreference.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ArrayList<String> ds_Namefont = new ArrayList<>();
    ArrayAdapter<String> adapter;
    String saveFont ="trang thia font ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        // thêm font vào ArrayList
        try {
            AssetManager manager = getAssets();
            String arrFont [] = manager.list("font");
            ds_Namefont.addAll(Arrays.asList(arrFont));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,ds_Namefont);
        binding.dsFont.setAdapter(adapter);

        addEvent();

        // load font đã lưu
        SharedPreferences preferences = getSharedPreferences(saveFont,MODE_PRIVATE);
        String font = preferences.getString("fontText","");
        if(font.length() >0){
            Typeface typeface = Typeface.createFromAsset(getAssets(),font);
            binding.txtHello.setTypeface(typeface);
        }




    }


    private void addEvent(){
        binding.dsFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set font

                // tham số 1 là AssetsManager , t2 là đường dẫn để thay đổi font
                Typeface typeface = Typeface.createFromAsset(getAssets(),"font/"+ds_Namefont.get(position));
                binding.txtHello.setTypeface(typeface);

                // Save font
                SharedPreferences preferences = getSharedPreferences(saveFont,MODE_PRIVATE);

                // lưu trong 1 file ở đt
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("fontText", "font/"+ ds_Namefont.get(position));
                editor.commit();

            }
        });
    }
}