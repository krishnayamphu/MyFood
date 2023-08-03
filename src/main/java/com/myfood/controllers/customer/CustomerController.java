package com.myfood.controllers.customer;

import com.myfood.dao.OrderDAO;
import com.myfood.models.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerController", value = "/my-orders")
public class CustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId=1;
        ArrayList<Order> orders= OrderDAO.getOrders(userId);
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/customer/myorder.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
