package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.User;
import edu.booking.booking.user.authentication.model.AuthenticationModel;
import edu.booking.booking.user.registration.model.RegistrationModel;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface UserServiceLocal {
    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    User login(AuthenticationModel authenticationModel);

    User findByUsername(String username);

    User register(RegistrationModel registrationModel);
}
