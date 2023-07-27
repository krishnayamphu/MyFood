package com.myfood.controllers.auth;

import com.myfood.dao.CustomerDAO;
import com.myfood.dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("auth/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       if (CustomerDAO.auth(email, DigestUtils.sha256Hex(password))){
            HttpSession session=request.getSession();
            session.setAttribute("user",email);
            response.sendRedirect("profile");
    }else{
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}

}
