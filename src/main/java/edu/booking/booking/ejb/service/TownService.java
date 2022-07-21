package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Town;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class TownService extends AbstractService<Town> implements TownServiceLocal {
    @PersistenceContext(unitName = "bookingPU")
    private EntityManager entityManager;

    public TownService() {
        super(Town.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
