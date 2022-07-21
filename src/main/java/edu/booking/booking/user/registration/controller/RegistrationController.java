package edu.booking.booking.user.registration.controller;

import edu.booking.booking.ejb.service.UserServiceLocal;
import edu.booking.booking.entity.User;
import edu.booking.booking.user.registration.model.RegistrationModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegistrationController {
    private final UserServiceLocal userServiceLocal;
    private final RegistrationModel registrationModel;

    public boolean usernameOccupied(){
        User user = userServiceLocal.findByUsername(registrationModel.getUsername());
        return user != null;
    }

    public boolean isValidRegistrationModel() {
        return !registrationModel.getName().isEmpty()
                && !registrationModel.getSurname().isEmpty()
                && !registrationModel.getUsername().isEmpty()
                && !registrationModel.getPlainPassword().isEmpty()
                && !registrationModel.getEmail().isEmpty()
                && !registrationModel.getCountry().isEmpty();
    }
}
