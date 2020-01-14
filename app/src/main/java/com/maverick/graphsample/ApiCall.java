package com.maverick.graphsample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {

    @GET("index.php")
    Call<List<GraphResponse>> getGraphData();
}
