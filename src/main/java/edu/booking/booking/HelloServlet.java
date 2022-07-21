package edu.booking.booking;

import java.io.*;
import java.util.List;

import edu.booking.booking.ejb.service.UserServiceLocal;
import edu.booking.booking.entity.User;
import jakarta.inject.Inject;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Inject
    private UserServiceLocal userServiceLocal;
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<User> users = userServiceLocal.findAll();
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<ul>");
        for (User user : users){
            out.println("<li>" + user.getUsername() + "</li>");
        }
        out.println("</ul>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}