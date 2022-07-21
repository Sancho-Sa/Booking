package edu.booking.booking.user.authentication.controller;

import edu.booking.booking.ejb.service.UserServiceLocal;
import edu.booking.booking.entity.User;
import edu.booking.booking.routes.Routes;
import edu.booking.booking.user.authentication.model.AuthenticationModel;
import edu.booking.booking.user.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AuthenticateDispatcherServlet", value = "/authenticate")
public class AuthenticateDispatcherServlet extends HttpServlet {
    @Inject
    private UserServiceLocal userServiceLocal;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        AuthenticationModel authenticationModel = AuthenticationModel.builder()
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .build();
        User user = userServiceLocal.login(authenticationModel);
        if (user != null){
            UserSession.USER.addToSession(user, request);
            RequestDispatcher dashBoardDispatcher = request.getRequestDispatcher(Routes.DASHBOARD_ACCESS);
            dashBoardDispatcher.forward(request, response);
        }else {
            RequestDispatcher loginDispatcher = request.getRequestDispatcher(Routes.LOGIN);
            loginDispatcher.forward(request, response);
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
