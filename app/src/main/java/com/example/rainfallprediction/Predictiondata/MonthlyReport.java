package com.example.rainfallprediction.Predictiondata;

import com.google.gson.annotations.SerializedName;

public class MonthlyReport {
    @SerializedName("year")
    private String year;
    @SerializedName("jan")
    private String jan;
    @SerializedName("feb")
    private String feb;
    @SerializedName("mar")
    private String mar;
    @SerializedName("apr")
    private String apr;
    @SerializedName("may")
    private String may;
    @SerializedName("jun")
    private String jun;
    @SerializedName("jul")
    private String jul;
    @SerializedName("aug")
    private String aug;
    @SerializedName("sept")
    private String sep;
    @SerializedName("oct")
    private String oct;
    @SerializedName("nov")
    private String nov;
    @SerializedName("dec")
    private String dec;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getJan() {
        return jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public String getFeb() {
        return feb;
    }

    public void setFeb(String feb) {
        this.feb = feb;
    }

    public String getMar() {
        return mar;
    }

    public void setMar(String mar) {
        this.mar = mar;
    }

    public String getApr() {
        return apr;
    }

    public void setApr(String apr) {
        this.apr = apr;
    }

    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    public String getJun() {
        return jun;
    }

    public void setJun(String jun) {
        this.jun = jun;
    }

    public String getJul() {
        return jul;
    }

    public void setJul(String jul) {
        this.jul = jul;
    }

    public String getAug() {
        return aug;
    }

    public void setAug(String aug) {
        this.aug = aug;
    }

    public String getSep() {
        return sep;
    }

    public void setSep(String sep) {
        this.sep = sep;
    }

    public String getOct() {
        return oct;
    }

    public void setOct(String oct) {
        this.oct = oct;
    }

    public String getNov() {
        return nov;
    }

    public void setNov(String nov) {
        this.nov = nov;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
