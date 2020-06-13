package com.tanmaya.tracovid;

public class Symptom {
    private String name;
    private String welness;
    private String date;
    private String ba;
    private String temp;
    private String symptoms;

    public Symptom(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWelness() {
        return welness;
    }

    public void setWelness(String welness) {
        this.welness = welness;
    }
    public String getba() {
        return ba;
    }

    public void setba(String ba) {
        this.ba = ba;
    }
    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp =temp;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
