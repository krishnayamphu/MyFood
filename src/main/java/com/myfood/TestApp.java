package com.myfood;

import com.myfood.dao.FoodDAO;
import com.myfood.dao.UserDAO;
import com.myfood.models.Food;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;

public class TestApp {
    public static void main(String[] args) {
        ArrayList<Food> foods= FoodDAO.getFoods();
        for (Food f:foods             ) {
            System.out.println(f.getName());
        }
    }
}
