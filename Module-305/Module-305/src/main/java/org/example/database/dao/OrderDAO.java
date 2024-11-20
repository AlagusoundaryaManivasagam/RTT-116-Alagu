package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(Order order){
        // for hibernate to do an update the product needs to be there already
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();
        // merge for update
        try{
            session.merge(order);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    public void create(Order order){
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();
        //persist for create
        try{
            session.persist(order);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }

    public void delete(Order order){
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();
        try{
            session.delete(order);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }
    public Order findById(Integer id) {
        // Hibernate queries must use the java names from the entities
        // this is HQL
        String hqlQuery = "SELECT o FROM Order o WHERE o.id = :orderId";
        // this is what is called native SQL - the native query only included here to show the difference
        // between HQL and native
        //String nativeSqlQuery = "select * from products where id = ?";

        // this is needed to get the database connection and let hibernate run the query
        Session session = factory.openSession();

        // hibernate uses this typed query to execute the query and fill "hydrate" the entity with the data from the database
        // passing in the HQL query and setting the datatype for hibernate to use
        TypedQuery<Order> query = session.createQuery(hqlQuery, Order.class);

        // now we can set the parameter on the query
        // the int id is the value that we want to substitute into the query at the
        // :productId location
        query.setParameter("orderId", id);

        // we know this is a primary key so this query will return 0 recrods or 1 record
        // if the product was not found in the database we want to return null from our function
        // otherwise we want to return our product
        // hibernate will run the query and create a new product entity and fill it up with the data for us
        try {
            Order result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            // no result was found .. for any number of reasons
            return null;
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }
}
