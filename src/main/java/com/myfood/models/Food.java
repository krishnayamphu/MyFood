package com.myfood.models;

public class Food {
    private int id;
    private String name;
    private String size;
    private double price;
    private String image;

    public Food() {
    }

    public Food(String name, String size, double price, String image) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public Food(int id, String name, String size, double price, String image) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
