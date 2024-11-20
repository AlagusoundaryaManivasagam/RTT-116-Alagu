package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

public class AddExistingProductName {
    public static void main(String[] args){
        ProductDAO productDAO = new ProductDAO();
        Product p =new Product();
        //we leave the primary key because hybernate will populate the entity with new id
        p.setProductVendor("xyz");
        p.setProductName("1969 Harley Davidson Ultimate Chopper");
        p.setQuantityInStock(4);
        p.setProductScale("scale");
        p.setProductlineId(5);
        p.setBuyPrice(60);
        p.setMsrp(50);
        p.setProductCode("abcd");
        p.setProductDescription("new product");
        System.out.println("before:" +p);
        productDAO.create(p);
        System.out.println("after:" + p);
        // this compiled and run but new product is not created because of the
        // unique constraint we added to the product name column
        // this trew an error message "ERROR: Duplicate entry '1969 Harley Davidson Ultimate Chopper'
        // for key 'products.product_name_UNIQUE'"
    }
}
