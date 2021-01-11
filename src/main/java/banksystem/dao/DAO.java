package banksystem.dao;

import banksystem.dao.model.Client;
import banksystem.dao.model.security.ConfirmationToken;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Component
public class DAO<R> {

    private Class<R> entityClass;
    @Autowired
    private SessionFactory sessionFactory;

    public R getById(final Long id){
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.get(entityClass, id);
        }
    }

    public Client getByEmail(final String email) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Client where email = :email");
            query.setParameter("email", email);
            return (Client) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Client getByUsername(final String username) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Client where username = :username");
            query.setParameter("username", username);
            return (Client) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Client getByPhone(final String phone) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Client where phoneNumber = :phone");
            query.setParameter("phone", phone);
            return (Client) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public Client getByPassport(final String passport) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Client where passNumber = :passport");
            query.setParameter("passport", passport);
            return (Client) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    public <T> void saveOrUpdate(final T o){
        try(Session session = sessionFactory.openSession()) {
            session.saveOrUpdate(o);
            session.beginTransaction().commit();
        }
    }

    public void delete(final Object object){
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();
        }
    }

    public <T> List<T> getAll() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            final Criteria crit = session.createCriteria(entityClass);
            return crit.list();
        }
    }

    public ConfirmationToken getByToken(final String token) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from ConfirmationToken where token = :token");
            query.setParameter("token", token);
            return (ConfirmationToken) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }


    protected void setEntityClass(Class<R> entityClass) {
        this.entityClass = entityClass;
    }
}
