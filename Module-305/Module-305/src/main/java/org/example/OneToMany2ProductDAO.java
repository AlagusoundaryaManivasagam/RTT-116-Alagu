package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class OneToMany2ProductDAO {
    public static void main(String[] args){
        //doubts to ask
        //The output showed an orderdetail with no id no order id and no product id
        // even before creating and updating the order details list
        //to set the order should we create the orderDAO as I did
        // I ran the program twice
        // first time with only productDAO.update
        // second time with orderDAO.update added
        //now I have three things added to my orderdetails list
        // In the middle of order detail list for product(After) I found a orderdetail
        //with id,product id and order id = 0


        ProductDAO productDAO= new ProductDAO();
        Product p = productDAO.findById(1);
        System.out.println(p);

        System.out.println("Before adding the new Order detail");
        for(OrderDetail od: p.getOrderDetails()){
            System.out.println(od);
        }

        OrderDAO orderDAO = new OrderDAO();
        Order o = orderDAO.findById(10100);
        System.out.println("Before adding new product to the order");
        for(OrderDetail od:o.getOrderDetails()){
            System.out.println(od);
        }

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

        System.out.println("After adding new product to the order");
        for(OrderDetail od:o.getOrderDetails()){
            System.out.println(od);
        }

    }
}
