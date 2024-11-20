package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class OneToMany3ProductDAO {
    public static void main(String[] args){
        //order detail shows up in both product.getorderdetails and order.getorderdetails
        //but the id, order id and product id are=0
        //I ran it once and two entries are made in the orderdetails.table

        ProductDAO productDAO= new ProductDAO();
        Product p = productDAO.findById(2);
        System.out.println(p);

        System.out.println("Before adding the new Order detail");
        for(OrderDetail od: p.getOrderDetails()){
            System.out.println(od);
        }
        System.out.println("============================================================================");

        OrderDAO orderDAO = new OrderDAO();
        Order o = orderDAO.findById(10100);
        System.out.println("Before adding new product to the order");
        for(OrderDetail od:o.getOrderDetails()){
            System.out.println(od);
        }

        System.out.println("============================================================================");

        OrderDetail newOd = new OrderDetail();
        newOd.setProduct(p);
        newOd.setOrder(o);
        newOd.setQuantityOrdered(100);
        newOd.setPriceEach(80);
        newOd.setOrderLineNumber(1);

        p.getOrderDetails().add(newOd);
        System.out.println(newOd);
        productDAO.update(p);

        o.getOrderDetails().add(newOd);
        orderDAO.update(o);

        System.out.println("After adding new order detail");
        for(OrderDetail od: p.getOrderDetails()){
            System.out.println(od);
        }
        System.out.println("========================================================================");

        System.out.println("After adding new product to the order");
        for(OrderDetail od:o.getOrderDetails()){
            System.out.println(od);
        }
        System.out.println("==========================================================================");

    }
}
