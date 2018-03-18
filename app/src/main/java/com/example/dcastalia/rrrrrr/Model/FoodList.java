package com.example.dcastalia.rrrrrr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodList {

    @SerializedName("Kitchen_id")
    @Expose
    private int kitchenId;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("Kitchen_name")
    @Expose
    private String kitchenName;
    @SerializedName("img_src")
    @Expose
    private String imgSrc;

    public int getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(int kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKitchenName() {
        return kitchenName;
    }

    public void setKitchenName(String kitchenName) {
        this.kitchenName = kitchenName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

}


