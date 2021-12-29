package com.example.android.model;

import java.util.ArrayList;
import java.util.List;

public class ModelConnom {

    private ArrayList<Location> locations = new ArrayList<>();
    private ArrayList<OverView> overViews = new ArrayList<>();

    private Today today;
    private Total total;

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<OverView> getOverViews() {
        return overViews;
    }

    public void setOverViews(ArrayList<OverView> overViews) {
        this.overViews = overViews;
    }

    public Today getToday() {
        return today;
    }

    public void setToday(Today today) {
        this.today = today;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }
}
