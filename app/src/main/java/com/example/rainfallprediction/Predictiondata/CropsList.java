package com.example.rainfallprediction.Predictiondata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CropsList {
    @SerializedName("crops")
    private List<Crop> cropList;

    public List<Crop> getCropList() {
        return cropList;
    }

    public void setCropList(List<Crop> cropList) {
        this.cropList = cropList;
    }
}
