package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Flight;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class FlightService extends AbstractService<Flight> implements FlightServiceLocal {
    @PersistenceContext(unitName = "bookingPU")
    private EntityManager entityManager;

    @Inject
    private TownServiceLocal townServiceLocal;

    public FlightService() {
        super(Flight.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void invalidateCache() {
        entityManager.getEntityManagerFactory().getCache().evictAll();
    }
}
