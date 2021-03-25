package com.example.rainfallprediction.Predictiondata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    public List<Report> getReport() {
        return report;
    }

    public void setReport(List<Report> report) {
        this.report = report;
    }

    @SerializedName(value = "Humidity", alternate = {"Pressure", "Rainfall", "Temperature", "Wind"})
   private List<Report> report;

}
