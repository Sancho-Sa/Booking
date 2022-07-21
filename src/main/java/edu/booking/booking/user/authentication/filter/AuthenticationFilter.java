package edu.booking.booking.user.authentication.filter;

import edu.booking.booking.entity.User;
import edu.booking.booking.user.session.UserSession;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = {"/dashboard/*"})
public class AuthenticationFilter implements Filter {
    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User sessionUser = UserSession.USER.getFromSession(request);
        if (sessionUser == null){
            response.sendRedirect(request.getContextPath() + "/login");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
