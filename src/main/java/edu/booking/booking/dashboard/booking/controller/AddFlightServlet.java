package edu.booking.booking.dashboard.booking.controller;

import edu.booking.booking.ejb.service.FlightServiceLocal;
import edu.booking.booking.entity.Flight;
import edu.booking.booking.entity.User;
import edu.booking.booking.routes.Routes;
import edu.booking.booking.user.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AddFlightServlet", value = "/addFlight")
public class AddFlightServlet extends HttpServlet {
    @Inject
    private FlightServiceLocal flightServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        User userSession = UserSession.USER.getFromSession(request);
        if (userSession != null){
            String departureAirport = request.getParameter("departureAirport");
            String arrivalAirport = request.getParameter("arrivalAirport");
            String departureDate = request.getParameter("departureDate");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(departureDate);
            Flight flight = new Flight();
            flight.setFrom(departureAirport);
            flight.setTo(arrivalAirport);
            flight.setDateOfFlight(date);
            flight.setUserCreatorId(userSession);
            flightServiceLocal.create(flight);
            List<Flight> flights = flightServiceLocal.findAll();
            request.setAttribute("flights", flights);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.FLIGHT);
            requestDispatcher.include(request, response);
        }else {
            response.sendRedirect(request.getContextPath());
        }
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            processRequest(request, response);
    }
}
