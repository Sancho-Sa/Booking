package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Town;
import jakarta.ejb.Local;

import java.util.List;

@Local
public interface TownServiceLocal {
    void create(Town town);

    void edit(Town town);

    void remove(Town town);

    Town find(Object id);

    List<Town> findAll();
}
