package com.example.dcastalia.rrrrrr.API;

import com.example.dcastalia.rrrrrr.Model.FoodList;
import com.example.dcastalia.rrrrrr.Model.Resturent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dcastalia on 3/6/18.
 */

public interface Retrofit3 {
    @GET("bins/17v3wh")
    public Call<List<FoodList>> getFood();
}
