package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class HibernateDemo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();

        // find product by id
        Product p1 = productDAO.findById(2);
        System.out.println(p1);

        // find product by name
        List<Product> list = productDAO.search("Ford");
        for(Product p: list){
            System.out.println(p);
        }

        // update product code
        Product p2 = productDAO.findById(1);
        System.out.println(p2);
        p2.setProductCode("bbb");
        productDAO.update(p2);

        Product p3 = productDAO.findById(1);
        System.out.println(p3);


}}
