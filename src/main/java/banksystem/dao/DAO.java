package banksystem.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    protected void setEntityClass(Class<R> entityClass) {
        this.entityClass = entityClass;
    }
}
