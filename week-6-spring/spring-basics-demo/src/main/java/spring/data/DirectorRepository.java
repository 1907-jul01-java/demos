package spring.data;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DirectorRepository
 */
@Repository
public class DirectorRepository {

    @Autowired
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Director> getAllDirectors() {
        return getSessionFactory()
            .getCurrentSession()
            .createQuery("from Director")
            .list();
    }
    
}