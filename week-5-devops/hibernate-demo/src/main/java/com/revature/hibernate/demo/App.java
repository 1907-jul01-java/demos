package com.revature.hibernate.demo;

import java.util.List;

import com.revature.hibernate.demo.domain.Director;
import com.revature.hibernate.demo.domain.Movie;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@SuppressWarnings("unchecked")
public class App {
    public static void main(String[] args) {
        // Configure and build SessionFactory
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        
        // Create a session
        Session session = sessionFactory.openSession();

        // Begin a transaction and save a new movie
        Transaction transaction = session.beginTransaction();
        Movie toyStory = new Movie(0, "Toy Story", 1999, new Director(0, "Randy Newman"));
        session.save(toyStory);
        transaction.commit();

        // After transaction, new movie is persisted and id automatically updated
        System.out.println(toyStory);

        // Begin a new transaction and delete movie by persisted entity
        transaction = session.beginTransaction();
        session.delete(toyStory);
        transaction.commit();

        // Query - write parameterized HQL and native SQL
        List<Movie> movies = session.createQuery("from Movie where id > :varId")
            .setInteger("varId", 2)
            .list();
        System.out.println(movies);

        // Criteria - programmatic SELECT statement
        movies = session.createCriteria(Movie.class)
            .add(Restrictions.between("id", 2, 10))
            .addOrder(Order.desc("title"))
            .list();

        // Persist movie from DB to Java object
        Movie jurassicPark = (Movie) session.get(Movie.class, 1);
        System.out.println(jurassicPark);

        session.close();
        sessionFactory.close();
    }
}
