package com.maverick.graphsample;

import com.google.gson.annotations.SerializedName;

public class GraphResponse {

    @SerializedName("year")
    private int Year;

    @SerializedName("growth_rate")
    private Float Growth_rate;

    public int getYear() {
        return Year;
    }

    public Float getGrowth_rate() {
        return Growth_rate;
    }
}
