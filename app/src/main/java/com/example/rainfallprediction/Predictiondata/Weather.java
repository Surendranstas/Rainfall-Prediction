package com.example.rainfallprediction.Predictiondata;

import com.google.gson.annotations.SerializedName;

public class Weather {

    private int year;
    @SerializedName("Jan")
    private String jan;
    @SerializedName("Feb")
    private String feb;
    @SerializedName("Mar")
    private String mar;
    @SerializedName("Apr")
    private String apr;
    @SerializedName("May")
    private String may;
    @SerializedName("Jun")
    private String jun;
    @SerializedName("Jul")
    private String jul;
    @SerializedName("Aug")
    private String aug;
    @SerializedName("Sep")
    private String sep;
    @SerializedName("Oct")
    private String oct;
    @SerializedName("Nov")
    private String nov;
    @SerializedName("Dec")
    private String dec;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
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
