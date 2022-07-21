package edu.booking.booking.user.registration.controller;

import edu.booking.booking.ejb.service.CountryServiceLocal;
import edu.booking.booking.ejb.service.UserServiceLocal;
import edu.booking.booking.entity.Country;
import edu.booking.booking.entity.User;
import edu.booking.booking.routes.Routes;
import edu.booking.booking.user.registration.model.RegistrationModel;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegisterDispatcherServlet", urlPatterns = {"/register"})
public class RegisterDispatcherServlet extends HttpServlet {
    @Inject
    private CountryServiceLocal countryServiceLocal;

    @Inject
    private UserServiceLocal userServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RegistrationModel registrationModel = RegistrationModel.builder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .username(request.getParameter("username"))
                .plainPassword(request.getParameter("password"))
                .email(request.getParameter("email"))
                .country(request.getParameter("country"))
                .build();
        RegistrationController controller = new RegistrationController(userServiceLocal, registrationModel);
        if (controller.isValidRegistrationModel()){
            if (controller.usernameOccupied()){

            }else {
                User user = userServiceLocal.register(registrationModel);
                if (user != null){
                    RequestDispatcher loginDispatcher = request.getRequestDispatcher(Routes.LOGIN);
                    loginDispatcher.forward(request, response);
                }else {

                }
            }
        }else {
            RequestDispatcher registerDispatcher = request.getRequestDispatcher(Routes.REGISTRATION);
            registerDispatcher.forward(request, response);
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
