package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Privilege;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PrivilegeService extends AbstractService<Privilege> implements PrivilegeServiceLocal{
    @PersistenceContext(unitName = "bookingPU")
    private EntityManager entityManager;

    public PrivilegeService() {
        super(Privilege.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
