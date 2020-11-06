package banksystem.dao;

import com.sun.istack.NotNull;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DAO {

    public DAO(@NotNull final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private SessionFactory sessionFactory;

    public <T> void save(final T o){
        Session session = sessionFactory.openSession();
        session.save(o);
        session.beginTransaction().commit();
    }

    public <T> T read(final Class<T> type, final Long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        T result = session.get(type, id);
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


    public <T> List<T> getAll(final Class<T> type) {
        final Session session = sessionFactory.openSession();
        session.beginTransaction();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }
}
