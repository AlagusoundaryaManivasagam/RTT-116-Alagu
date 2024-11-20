package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.OrderDetail;
import org.example.database.entity.Product;

public class OneToManyProductDAO {
    public static void main(String[] args){
        ProductDAO productDAO = new ProductDAO();
        Product p = productDAO.findById(2);
        System.out.println(p);

        // we are able to use p.getOrderDetails() and od.getProduct() here because of the one to many and
        // many to one annotations we added(we created a parent child relationships between these tables
        // i.e why we can access orderdetails(children) for a particular product(parent)
        // and get product(parent) for a particular orderdetail(child)

        for(OrderDetail od: p.getOrderDetails()){
            System.out.println(od);
            System.out.println(od.getProduct());
        }
    }
}
