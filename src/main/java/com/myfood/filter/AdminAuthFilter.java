package com.myfood.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminAuthFilter", urlPatterns = {"/admin/*"})
public class AdminAuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;
        HttpSession session=req.getSession(false);
        if(session==null){
            res.sendRedirect("/myfood/admin-login");
        }else{
            String user= (String) session.getAttribute("admin");
            if(user==null){
                res.sendRedirect("/myfood/admin-login");
            }else{
                chain.doFilter(request, response);
            }
        }
    }
}
