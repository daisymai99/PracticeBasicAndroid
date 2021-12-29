package com.example.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {
    @SerializedName("death")
    @Expose
    private Integer death;
    @SerializedName("treating")
    @Expose
    private Integer treating;
    @SerializedName("cases")
    @Expose
    private Integer cases;
    @SerializedName("recovered")
    @Expose
    private Integer recovered;

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    public Integer getTreating() {
        return treating;
    }

    public void setTreating(Integer treating) {
        this.treating = treating;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }
}
