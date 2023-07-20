package com.myfood.dao;

import com.myfood.database.ConnectDB;
import com.myfood.models.Food;
import com.myfood.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDAO {
    public static ArrayList<Food> getFoods() {
        ArrayList<Food> foods = new ArrayList<>();
        String sql = "SELECT * FROM foods";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                foods.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getString("size"),rs.getDouble("price"),rs.getString("image")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return foods;
    }

    public static User getUsers(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public static boolean saveFood(Food food) {
        boolean status = false;
        String sql = "INSERT INTO foods (name,size,price,image) VALUES (?,?,?,?)";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, food.getName());
            ps.setString(2, food.getSize());
            ps.setDouble(3,food.getPrice());
            ps.setString(4,food.getImage());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static boolean updateUser(User user) {
        boolean status = false;
        String sql = "UPDATE users SET username=?,password=? WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static boolean deleteFood(int id) {
        boolean status = false;
        String sql = "DELETE FROM foods WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
