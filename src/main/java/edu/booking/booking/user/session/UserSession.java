package edu.booking.booking.user.session;

import edu.booking.booking.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public enum UserSession {
    USER("SESSION_KEY");

    private String sessionKey;

    UserSession(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public void addToSession(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute(sessionKey) == null){
            session.setAttribute(sessionKey, user);
        }
    }

    public User getFromSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        return (User) session.getAttribute(sessionKey);
    }
}
