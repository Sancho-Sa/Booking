package edu.booking.booking.user.registration.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationModel {
    private String name;
    private String surname;
    private String username;
    private String plainPassword;
    private String email;
    private String country;

    public Integer getCountryId(){
        if (country.contains("[")){
            String countryIdText = country.substring(country.indexOf("[") + 1, country.indexOf("]"));
            return Integer.parseInt(countryIdText);
        }else {
            return Integer.parseInt(country);
        }
    }
}
