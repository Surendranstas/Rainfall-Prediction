package com.example.rainfallprediction.Predictiondata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Crop {
    @SerializedName("Name")
    private String cropName;
    @SerializedName("Cultivate")
    private List<String> Cultivate;
    @SerializedName("Temp")
    private String Temp;
    @SerializedName("Soil")
    private String Soil;

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public List<String> getCultivate() {
        return Cultivate;
    }

    public void setCultivate(List<String> cultivate) {
        Cultivate = cultivate;
    }

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String temp) {
        Temp = temp;
    }

    public String getSoil() {
        return Soil;
    }

    public void setSoil(String soil) {
        Soil = soil;
    }
}
