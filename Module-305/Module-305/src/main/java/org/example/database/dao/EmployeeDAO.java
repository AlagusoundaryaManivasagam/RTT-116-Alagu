package org.example.database.dao;

import org.example.database.entity.Customer;
import jakarta.persistence.TypedQuery;
import org.example.database.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
public class EmployeeDAO {
    private SessionFactory factory = new Configuration().configure().buildSessionFactory();

    public Employee createEmployee(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.persist(employee);
        session.getTransaction().commit();
        return employee;
    }

    public void deleteEmployee(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.delete(employee);
        session.getTransaction().commit();
    }

    public Employee updateEmployee(Employee employee) {
        Session session = factory.openSession();
        session.getTransaction().begin();
        session.merge(employee);
        session.getTransaction().commit();
        return employee;
    }

    public Employee findById(Integer id){

        Session session = factory.openSession();

        String hqlQuery = "SELECT e FROM Employee e WHERE e.id = :employeeId";       //Hibernate Query Language

        TypedQuery<Employee> query = session.createQuery(hqlQuery, Employee.class);
        query.setParameter("employeeId", id);

        try {
            Employee result = query.getSingleResult();
            return result;
        }catch (Exception e) {
            return null;

        }finally {
            session.close();
        }
    }

    public List<Employee> findByFirstName(String firstName){
        Session session = factory.openSession();

        String hqlQuery = "SELECT e from Employee e WHERE e.firstName = :firstName";
        TypedQuery<Employee> query = session.createQuery(hqlQuery, Employee.class);
        query.setParameter("firstName", firstName);

        try{
            List<Employee> result = query.getResultList();
            return result;
        }catch(Exception e){
            return new ArrayList<>();
        }finally{
            session.close();
        }
    }

    public Employee findByEmail(String email){
        Session session = factory.openSession();

        String hqlQuery = "SELECT e FROM Employee e WHERE e.email = :email";       //Hibernate Query Language

        TypedQuery<Employee> query = session.createQuery(hqlQuery, Employee.class);
        query.setParameter("email",email);

        try {
            Employee result = query.getSingleResult();
            return result;
        }catch (Exception e) {
            return null;

        }finally {
            session.close();
        }
    }


}
