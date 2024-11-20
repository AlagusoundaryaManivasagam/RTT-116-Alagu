package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class OneToMany5ProductDOA {
    public static void main(String[] args){
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

        Order o = orderDAO.findById(10100);
        Product p = productDAO.findById(1);

        OrderDetail od = orderDetailDAO.findByOrderIdAndProductId(o.getId(),p.getId());

        if(od == null){
            od = new OrderDetail();
            od.setOrder(o);
            od.setProduct(p);
            od.setQuantityOrdered(100);
            od.setPriceEach(80);
            od.setOrderLineNumber(1);

            orderDetailDAO.create(od);
        }
        else{
            od.setQuantityOrdered(od.getQuantityOrdered()+100);
            orderDetailDAO.update(od);
        }
    }
}
