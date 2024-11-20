package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

public class CreateProductDemo {
    public static void main(String[] args){
        ProductDAO productDAO = new ProductDAO();
        Product p =new Product();
        //we leave the primary key because hybernate will populate the entity with new id
        p.setProductVendor("xyz");
        p.setProductName("Ball");
        p.setQuantityInStock(4);
        p.setProductScale("scale");
        p.setProductlineId(5);
        p.setBuyPrice(60);
        p.setMsrp(50);
        p.setProductCode("abcd");
        p.setProductDescription("new product");
        System.out.println("before:" +p);

        if(productDAO.findByName(p.getProductName()) == null) {

            productDAO.create(p);
            System.out.println("after:" + p);
        }else{
            System.out.println("The product already exists in Products table");
        }

    }
}
