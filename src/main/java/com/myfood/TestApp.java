package com.myfood;

import com.myfood.dao.FoodDAO;
import com.myfood.dao.OrderDAO;
import com.myfood.dao.UserDAO;
import com.myfood.models.Food;
import com.myfood.models.Order;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<Order> orders= OrderDAO.getOrders(1);
        for (Order o:orders             ) {
            System.out.println(o.getId());
        }
    }
}
