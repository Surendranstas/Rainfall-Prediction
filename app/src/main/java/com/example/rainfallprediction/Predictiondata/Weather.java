package com.example.rainfallprediction.Predictiondata;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    public List<MonthlyReport> getGetMonthlyReport() {
        return getMonthlyReport;
    }

    public void setGetMonthlyReport(List<MonthlyReport> getMonthlyReport) {
        this.getMonthlyReport = getMonthlyReport;
    }

    @SerializedName(value = "Humidity", alternate = {"Pressure", "Rainfall", "Temperature", "Wind"})
   private List<MonthlyReport> getMonthlyReport;

}
