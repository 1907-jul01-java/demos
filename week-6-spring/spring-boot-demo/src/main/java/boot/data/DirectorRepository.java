package boot.data;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * DirectorRepository
 */
@Repository
@Transactional
public class DirectorRepository {

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public List<Director> getAllDirectors() {
        return getSession().createQuery("from Director", Director.class).list();
    }

    public Director postDirector(Director director) {
        Director newDirector = director;
        getSession().persist("Director", newDirector);
        return newDirector;
    }

}