package com.example.android.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android.R;
import com.example.android.model.OverView;


import java.util.List;

public class OverviewAdapter extends ArrayAdapter<OverView> {
    Activity context;
    int resource;
    @NonNull List<OverView> objects;
    public OverviewAdapter(@NonNull Activity context, int resource, @NonNull List<OverView> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        row = inflater.inflate(this.resource,null);

        TextView overViewDate = row.findViewById(R.id.overViewDate);
        TextView overViewDeath = row.findViewById(R.id.overviewdeath);
        TextView overViewTreating = row.findViewById(R.id.overviewtreating);
        TextView overViewCases = row.findViewById(R.id.overviewcases);
        TextView overViewRecovered = row.findViewById(R.id.overviewDateRecovered);

        overViewDate.setText(""+this.objects.get(position).getDate());
        overViewDeath.setText(""+this.objects.get(position).getDeath());
        overViewTreating.setText(""+this.objects.get(position).getTreating());
        overViewCases.setText(""+this.objects.get(position).getCases());
        overViewRecovered.setText(""+this.objects.get(position).getRecovered());

        return row;
    }
}
