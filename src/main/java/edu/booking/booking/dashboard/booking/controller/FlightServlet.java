package edu.booking.booking.dashboard.booking.controller;

import edu.booking.booking.ejb.service.FlightServiceLocal;
import edu.booking.booking.entity.Flight;
import edu.booking.booking.routes.Routes;
import edu.booking.booking.user.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FlightServlet", value = "/flight")
public class FlightServlet extends HttpServlet {
    @Inject
    private FlightServiceLocal flightServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if (UserSession.USER.getFromSession(request) != null){
            flightServiceLocal.invalidateCache();
            List<Flight> flights = flightServiceLocal.findAll();
            request.setAttribute("flights", flights);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.FLIGHT);
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
