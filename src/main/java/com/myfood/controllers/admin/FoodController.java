package com.myfood.controllers.admin;

import com.myfood.dao.FoodDAO;
import com.myfood.models.Food;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FoodController", value = "/admin/food")
public class FoodController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Food> foods= FoodDAO.getFoods();
        request.setAttribute("foods",foods);
        request.getRequestDispatcher("/admin/food/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        FoodDAO.deleteFood(id);
        response.sendRedirect("/myfood/admin/food");
    }
}
