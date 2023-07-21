package com.myfood.controllers.admin;

import com.myfood.dao.FoodDAO;
import com.myfood.models.Food;
import com.myfood.utils.Media;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FoodEditController", value = "/admin/food-edit")
public class FoodEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Food food= FoodDAO.getFood(id);
        String path=getServletContext().getRealPath("/uploads");
        ArrayList<String> allFiles= Media.allFiles(path);
        request.setAttribute("allFiles",allFiles);
        request.setAttribute("food",food);
        request.getRequestDispatcher("/admin/food/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String size=request.getParameter("size");
        double price=Double.parseDouble(request.getParameter("price"));
        String image=request.getParameter("image");
        Food food=new Food(id,name,size,price,image);
        FoodDAO.updateFood(food);
        response.sendRedirect("/myfood/admin/food");
    }
}
