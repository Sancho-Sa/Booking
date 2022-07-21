package edu.booking.booking.user.registration.controller;

import edu.booking.booking.ejb.service.CountryServiceLocal;
import edu.booking.booking.entity.Country;
import edu.booking.booking.routes.Routes;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistrationDispatcherServlet", value = "/registration")
public class RegistrationDispatcherServlet extends HttpServlet {
    @Inject
    private CountryServiceLocal countryServiceLocal;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Country> countries = countryServiceLocal.findAll();
        request.setAttribute("countries", countries);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.REGISTRATION);
        requestDispatcher.forward(request, response);
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
