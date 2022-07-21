package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Country;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface CountryServiceLocal {
    void create(Country country);

    void edit(Country country);

    void remove(Country country);

    Country find(Object id);

    List<Country> findAll();
}
