package com.myfood.controllers.customer;

import com.myfood.dao.FoodDAO;
import com.myfood.dao.OrderDAO;
import com.myfood.models.Food;
import com.myfood.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerOrderController", value = "/orders")
public class CustomerOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Food food = FoodDAO.getFood(id);
        request.setAttribute("food", food);
        request.getRequestDispatcher("customer/order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int uid=1;
        int foodId=Integer.parseInt(request.getParameter("fid"));
        double total=Double.parseDouble(request.getParameter("tid"));
        Order order=new Order();
        order.setUserId(uid);
        order.setFoodId(foodId);
        order.setTotal(total);
        order.setStatus(0);
        OrderDAO.saveOrder(order);
        response.sendRedirect("/myfood/my-orders");
    }
}
