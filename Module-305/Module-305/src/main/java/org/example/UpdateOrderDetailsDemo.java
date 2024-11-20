package org.example;

import org.example.database.dao.OrderDetailDAO;
import org.example.database.entity.OrderDetail;

import java.util.List;
import java.util.Scanner;

public class UpdateOrderDetailsDemo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
        System.out.println("Enter the Order Id you would like to update");
        int orderId = scanner.nextInt();
        List<OrderDetail> list = orderDetailDAO.findByOrderId(orderId);

        for(OrderDetail od: list) {
            System.out.println(od.getId()+") Product Id = "+od.getProductId()+
                    ", Quantity Ordered = "+od.getQuantityOrdered());
        }
        System.out.println("Enter the id to be updated");
        while(true) {
            int id = scanner.nextInt();
            OrderDetail number = orderDetailDAO.findById(id);

            if (orderId == number.getOrderId()) {
                OrderDetail od = orderDetailDAO.findById(id);
                System.out.println(od);

                System.out.println("Enter the new quantity");
                int quantity = scanner.nextInt();
                od.setQuantityOrdered(quantity);
                orderDetailDAO.update(od);
                System.out.println("The updated order detail is as follows");
                List<OrderDetail> list1 = orderDetailDAO.findByOrderId(orderId);

                for (OrderDetail order : list1) {
                    System.out.println(order.getId() + ") Product Id = " + order.getProductId() +
                            ", Quantity Ordered = " + order.getQuantityOrdered());
                }
                break;
            } else {
                System.out.println("Please enter valid id");
            }
        }

        //System.out.println("Product id : " + od.getProductId()+", Quantity : " + od.getQuantityOrdered());

    }
}
