package com.myfood.controllers.admin;

import com.myfood.dao.FoodDAO;
import com.myfood.models.Food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FoodAddController", value = "/admin/food-add")
public class FoodAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/food/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String size=request.getParameter("size");
        double price=Double.parseDouble(request.getParameter("price"));
        String image=request.getParameter("image");
        Food food=new Food(name,size,price,image);
        FoodDAO.saveFood(food);
        response.sendRedirect("/myfood/admin/food");
    }
}
