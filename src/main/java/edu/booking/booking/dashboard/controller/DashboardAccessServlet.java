package edu.booking.booking.dashboard.controller;

import edu.booking.booking.routes.Routes;
import edu.booking.booking.user.session.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DashboardAccessServlet", urlPatterns = {"/dashboardAccess"})
public class DashboardAccessServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (UserSession.USER.getFromSession(request)!=null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.DASHBOARD);
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect(request.getContextPath());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
