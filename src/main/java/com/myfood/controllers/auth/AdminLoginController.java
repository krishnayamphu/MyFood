package com.myfood.controllers.auth;

import com.myfood.dao.UserDAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminLoginController", value = "/admin-login")
public class AdminLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("auth/admin-login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        if(UserDAO.auth(username, DigestUtils.sha256Hex(password))){
            HttpSession session=request.getSession();
            session.setAttribute("admin",username);
            response.sendRedirect("admin");
        }else{
            request.getRequestDispatcher("auth/admin-login.jsp").forward(request,response);
        }
    }
}
