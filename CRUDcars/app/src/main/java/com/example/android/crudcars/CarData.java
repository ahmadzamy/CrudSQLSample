package com.example.android.crudcars;

/**
 * Created by Ahmad Siafaddin on 11/2/2017.
 */

public class CarData {
    private String carName;
    private String carColor;
    private int id;
    private int Model;
    private int carPrice;

    public CarData(int id, String carName, String carColr, int carModel, int carPrice) {
        this.carName = carName;
        this.carColor = carColr;
        this.id = id;
        setModel(carModel);
        this.carPrice = carPrice;
    }

    public CarData(String[] arrays) {
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModel() {
        return Model;
    }

    public void setModel(int model) {

        this.Model = model >2018?2018: model;

    }

    public String getCarPrice() {
        return carPrice + "$";
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }
}
