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
    public static ArrayList<Order> getOrders(int userId) {
        ArrayList<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE user_id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,userId);
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

    public static Order getOrder(int id) {
        Order order = null;
        String sql = "SELECT * FROM orders WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order=new Order();
                order.setId(rs.getInt("id"));
                order.setFoodId(rs.getInt("food_id"));
                order.setUserId(rs.getInt("user_id"));
                order.setTotal(rs.getDouble("total"));
                order.setStatus(rs.getInt("status"));
                order.setCreatedAt(rs.getString("created_at"));
                 }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return order;
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

    public static boolean updateOrder(int id, int statusId) {
        boolean status = false;
        String sql = "UPDATE orders SET status=? WHERE id=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1,statusId);
            ps.setInt(2,id);
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
