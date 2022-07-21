package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Flight;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface FlightServiceLocal {
    void create(Flight flight);

    void edit(Flight flight);

    void remove(Flight flight);

    Flight find(Object id);

    List<Flight> findAll();

    void invalidateCache();
}
