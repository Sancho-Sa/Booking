package edu.booking.booking.user.authentication.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationModel {
    private String username;
    private String password;
}
