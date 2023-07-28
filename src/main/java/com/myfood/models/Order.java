package com.myfood.models;

public class Order {
    private int id;
    private int foodId;
    private int userId;
    private double total;
    private int status;
    private String createdAt;

    public Order() {
    }

    public Order(int foodId, int userId, double total) {
        this.foodId = foodId;
        this.userId = userId;
        this.total = total;
    }

    public Order(int id, int foodId, int userId, double total, int status, String createdAt) {
        this.id = id;
        this.foodId = foodId;
        this.userId = userId;
        this.total = total;
        this.status = status;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
