package com.example.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.android.R;
import com.example.android.model.Result;

import java.util.List;

public class AdapterListMovie extends ArrayAdapter<Result> {

    List<Result> list;
    Context context;

    public AdapterListMovie(@NonNull Context context, int resource, @NonNull List<Result> objects) {
        super(context, resource, objects);
        this.list = objects;
        this.context= context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Result result = list.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);

        TextView textView = convertView.findViewById(R.id.textView);
        ImageView  imageView = convertView.findViewById(R.id.image_item);

        Glide.with(context).load(result.getPosterPath()).into(imageView);
        textView.setText(result.getTitle());


        return convertView;

    }


}
