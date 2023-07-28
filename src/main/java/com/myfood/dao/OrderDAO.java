package com.myfood.dao;

import com.myfood.database.ConnectDB;
import com.myfood.models.Food;
import com.myfood.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
    public static ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order=new Order();
                order.setId(rs.getInt("id"));
                order.setFoodId(rs.getInt("food_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotal(rs.getDouble("total"));
                order.setStatus(rs.getInt("status"));
                order.setCreatedAt(rs.getString("created_at"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public static Food getFood(int id) {
        Food food = null;
        String sql = "SELECT * FROM foods WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                food = new Food(rs.getInt("id"), rs.getString("name"), rs.getString("size"),rs.getDouble("price"),rs.getString("image"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return food;
    }

    public static boolean saveOrder(Order order) {
        boolean status = false;
        String sql = "INSERT INTO orders (food_id,user_id,total,status) VALUES (?,?,?,?)";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, order.getFoodId());
            ps.setInt(2, order.getUserId());
            ps.setDouble(3,order.getTotal());
            ps.setInt(4,order.getStatus());
            if (ps.executeUpdate() == 1) {
                status = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static boolean updateFood(Food food) {
        boolean status = false;
        String sql = "UPDATE foods SET name=?,size=?,price=?,image=? WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, food.getName());
            ps.setString(2, food.getSize());
            ps.setDouble(3, food.getPrice());
            ps.setString(4,food.getImage());
            ps.setInt(5,food.getId());
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
