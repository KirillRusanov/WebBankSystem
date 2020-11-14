package banksystem.dao;

import banksystem.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAO<R> {

    private Class<R> entityClass;
    private SessionFactory sessionFactory;

    public DAO(Class<R> entityClass) {
        sessionFactory = HibernateUtil.getSessionFactory();
        this.entityClass = entityClass;
    }

    public <T> void create(final T o){
        System.out.println(sessionFactory.openSession());
        Session session = sessionFactory.openSession();
        session.save(o);
        session.beginTransaction().commit();
    }

    public R getById(final Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        R result = session.get(entityClass, id);
        session.close();
        return result;
    }

    public <T> void update(final T o){
        sessionFactory.openSession().close();
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(o);
        session.beginTransaction().commit();
        session.close();
    }

    public void delete(final Object object){
        sessionFactory.openSession().close();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    public <T> List<T> getAll() {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        final Criteria crit = session.createCriteria(entityClass);
        return crit.list();
    }
}
