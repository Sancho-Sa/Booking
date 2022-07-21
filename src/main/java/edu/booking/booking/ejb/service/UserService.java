package edu.booking.booking.ejb.service;

import edu.booking.booking.entity.Country;
import edu.booking.booking.entity.Privilege;
import edu.booking.booking.entity.User;
import edu.booking.booking.user.authentication.model.AuthenticationModel;
import edu.booking.booking.user.registration.model.RegistrationModel;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.*;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UserService extends AbstractService<User> implements UserServiceLocal{
    @PersistenceContext(unitName = "bookingPU")
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash pbkdf2PasswordHash;

    @Inject
    private CountryServiceLocal countryServiceLocal;

    @Inject
    private PrivilegeServiceLocal privilegeServiceLocal;

    public UserService() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public User login(AuthenticationModel authenticationModel) {
        User user = null;
        try {
            user = findByUsername(authenticationModel.getUsername());
            if (user == null){
                return null;
            }
            String plainPassword = authenticationModel.getPassword();
            String hashedPassword = user.getPassword();
            if (!pbkdf2PasswordHash.verify(plainPassword.toCharArray(), hashedPassword)){
                user = null;
                throw new NoResultException("Wrong password");
            }
        }catch (NoResultException | NonUniqueResultException exception){
            Logger.getLogger("USERNAME QUERY").log(Level.INFO, exception.getMessage());
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            Query query = entityManager.createNamedQuery("User.findByUsername");
            query.setParameter("username", username);
            user = (User) query.getSingleResult();
            return user;
        }catch (NoResultException | NonUniqueResultException exception){
            Logger.getLogger("USERNAME QUERY").log(Level.INFO, exception.getMessage());
        }
        return user;
    }

    @Override
    public User register(RegistrationModel registrationModel) {
        User user = findByUsername(registrationModel.getUsername());
        if (user == null){
            user = new User();
            user.setName(registrationModel.getName());
            user.setSurname(registrationModel.getSurname());
            user.setUsername(registrationModel.getUsername());
            String hashedPassword = pbkdf2PasswordHash.generate(registrationModel.getPlainPassword().toCharArray());
            user.setPassword(hashedPassword);
            user.setEmail(registrationModel.getEmail());
            Country selectedCountry = countryServiceLocal.find(registrationModel.getCountryId());
            user.setCountryId(selectedCountry);
            Privilege privilege = privilegeServiceLocal.find(Privilege.CLIENT_PRIVILEGE);
            user.setPrivilegeId(privilege);
            create(user);
        }
        return user;
    }
}
