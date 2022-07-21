package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Country;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class CountryService extends AbstractService<Country> implements CountryServiceLocal {
    @PersistenceContext(unitName = "bookingPU")
    private EntityManager entityManager;

    public CountryService() {
        super(Country.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
