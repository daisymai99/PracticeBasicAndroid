package com.example.sqlite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter  extends ArrayAdapter<BaiHat> {

    List<BaiHat> data;
    Activity context;
    int resource;


    public SongAdapter(@NonNull Activity context, int resource, @NonNull List<BaiHat> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.data = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        convertView = layoutInflater.inflate(this.resource, null);

        BaiHat baiHat = this.data.get(position);
        TextView _tenBH = convertView.findViewById(R.id.songName);
        TextView _maBH = convertView.findViewById(R.id.songID);
        TextView _casi = convertView.findViewById(R.id.songSinger);
        TextView _theLoai = convertView.findViewById(R.id.songKind);

        _maBH.setText(baiHat.getMaBH());
        _tenBH.setText(baiHat.getTeBH());
        _casi.setText(baiHat.getCasi());
        _theLoai.setText(baiHat.getTheLoai());

        return convertView;
    }
}
