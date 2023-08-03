package com.myfood.controllers.admin;

import com.myfood.dao.OrderDAO;
import com.myfood.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminOrderEditController", value = "/admin/order-edit")
public class AdminOrderEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Order order= OrderDAO.getOrder(id);
        request.setAttribute("order",order);
        request.getRequestDispatcher("/admin/order/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        int status=Integer.parseInt(request.getParameter("status"));
        OrderDAO.updateOrder(id,status);
        response.sendRedirect("/myfood/admin/orders");
    }
}
