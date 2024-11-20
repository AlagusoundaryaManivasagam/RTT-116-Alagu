package org.example.database.dao;

import org.example.database.entity.Product;

public class Runner {
    public static void main(String[] args){
        ProductDAO p = new ProductDAO();
        Product  p1 = p.findById(1);
        System.out.println(p1);
    }
}
