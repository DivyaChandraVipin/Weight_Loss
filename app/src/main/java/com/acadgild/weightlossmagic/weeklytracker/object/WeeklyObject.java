package com.acadgild.weightlossmagic.weeklytracker.object;

/**
 * Created by DivyaVipin on 3/7/2017.
 */

public class WeeklyObject {
    private int id;
    private int weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHip() {
        return hip;
    }

    public void setHip(int hip) {
        this.hip = hip;
    }

    public int getChest() {
        return chest;
    }

    public void setChest(int chest) {
        this.chest = chest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private int waist;
    private int hip;
    private int chest;
    private String date;
    public WeeklyObject()
    {

    }
    public WeeklyObject(int id,int weight, int waist,int hip,int chest, String date) {
        this.id = id;
        this.weight = weight;
        this.hip = hip;
        this.chest=chest;
        this.date=date;
    }

}
