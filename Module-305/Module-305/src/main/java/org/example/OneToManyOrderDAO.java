package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;

public class OneToManyOrderDAO {
    public static void main(String[] args){
        OrderDAO orderDAO= new OrderDAO();
        Order o = orderDAO.findById(10100);
        System.out.println(o);

        // we are able to use o.getOrderDetails() and od.getOrder() here because of the one to many and
        // many to one annotations we added(we created a parent child relationships between these tables
        // i.e why we can access orderdetails(children) for a particular order(parent)
        // and get order(parent) for a particular orderdetail(child)
        for(OrderDetail od : o.getOrderDetails()){
            System.out.println(od);
            System.out.println(od.getOrder());

        }

    }
}
