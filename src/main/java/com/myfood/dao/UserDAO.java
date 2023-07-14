package com.myfood.dao;

import com.myfood.database.ConnectDB;
import com.myfood.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
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

    public static boolean saveUser(User user) {
        boolean status = false;
        String sql = "INSERT INTO users (username,password) VALUES (?,?)";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
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

    public static boolean deleteUser(int id) {
        boolean status = false;
        String sql = "DELETE FROM users WHERE id=?";
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

    public static boolean auth(String username, String password) {
        boolean status = false;
        User user = null;
        String sql = "SELECT * FROM users WHERE username=? AND password=?";
        Connection cn = ConnectDB.connect();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                status = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
