package com.myfood.controllers.customer;

import com.myfood.dao.CustomerDAO;
import com.myfood.models.Customer;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerRegisterController", value = "/register")
public class CustomerRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        String password=request.getParameter("password");
        Customer customer=new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setMobile(mobile);
        customer.setPassword(DigestUtils.sha256Hex(password));
        CustomerDAO.saveUser(customer);
        response.sendRedirect("login");
    }
}
