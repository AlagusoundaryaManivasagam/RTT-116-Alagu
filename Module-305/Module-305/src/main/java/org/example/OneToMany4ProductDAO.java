package org.example;

import org.example.database.dao.OrderDAO;
import org.example.database.dao.OrderDetailDAO;
import org.example.database.dao.ProductDAO;
import org.example.database.entity.Order;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OneToMany4ProductDAO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the order id you would like to update");
        int orderId;
        orderId = scanner.nextInt();
        OrderDAO orderDAO = new OrderDAO();
        Order o = orderDAO.findById(orderId);

        System.out.println("Enter the product you would like to add to the order");
        int id ;
        id = scanner.nextInt();
        System.out.println("Enter the quantity of product");
        int quantity;
        quantity = scanner.nextInt();

        ProductDAO productDAO = new ProductDAO();
        Product p = productDAO.findById(id);
        System.out.println(p);

        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();


        List<Integer> productIdList = new ArrayList<>();
        for(OrderDetail od: o.getOrderDetails()){
            productIdList.add(od.getProductId());
        }




        if(!(productIdList.contains(p.getId()))) {

            OrderDetail newOd = new OrderDetail();
            newOd.setProduct(p);
            newOd.setOrder(o);
            newOd.setQuantityOrdered(100);
            newOd.setPriceEach(80);
            newOd.setOrderLineNumber(1);


            p.getOrderDetails().add(newOd);
            System.out.println(newOd);
            productDAO.update(p);
        }else{
            for(OrderDetail od: o.getOrderDetails()){
                if(od.getProductId()== p.getId()){
                    od.setQuantityOrdered(od.getQuantityOrdered()+100);
                    orderDetailDAO.update(od);
                    break;
                }
            }

        }



    }

}
