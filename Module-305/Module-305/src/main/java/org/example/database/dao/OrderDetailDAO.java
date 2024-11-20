package org.example.database.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.entity.OrderDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public void update(OrderDetail orderDetail){
        // for hibernate to do an update the product needs to be there already
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();
        // merge for update
        try{
            session.merge(orderDetail);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
    }
    public void create(OrderDetail orderDetail){
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();
        //persist for create
        try{
            session.persist(orderDetail);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }

    public void delete(OrderDetail orderDetail){
        Session session = factory.openSession();
        // starting a database transaction
        session.getTransaction().begin();
        try{
            session.delete(orderDetail);
            session.getTransaction().commit();
        } catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }

    }
    public OrderDetail findById(Integer id) {

        String hqlQuery = "SELECT od FROM OrderDetail od WHERE od.id = :id";

        Session session = factory.openSession();


        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);


        query.setParameter("id", id);


        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }

    public OrderDetail findByOrderIdAndProductId(int orderId, int productId){
        String hqlQuery = "SELECT od FROM OrderDetail od WHERE od.order.id = :orderId and od.product.id = :productId";

        Session session = factory.openSession();


        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);


        query.setParameter("orderId", orderId);
        query.setParameter("productId", productId);



        try {
            OrderDetail result = query.getSingleResult();
            return result;
        } catch ( Exception e ) {
            return null;
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }

    public List<OrderDetail> findByOrderId(Integer orderId){
        String hqlQuery = "SELECT od FROM OrderDetail od WHERE od.orderId = :orderId";

        Session session = factory.openSession();


        TypedQuery<OrderDetail> query = session.createQuery(hqlQuery, OrderDetail.class);


        query.setParameter("orderId", orderId);


        try {
            List<OrderDetail> result = query.getResultList();
            return result;
        } catch ( Exception e ) {
            return new ArrayList<>();
        } finally {
            // have to close the session at the end .. which tells hibernate to give the connection back to the pool
            session.close();
        }
    }
}
