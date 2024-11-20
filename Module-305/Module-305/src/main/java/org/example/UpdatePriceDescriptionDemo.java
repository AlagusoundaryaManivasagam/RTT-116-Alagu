package org.example;

import org.example.database.dao.ProductDAO;
import org.example.database.entity.Product;

import java.util.Scanner;

public class UpdatePriceDescriptionDemo {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();
        System.out.println("Enter the Product Id you would like to update");
        int productId = scanner.nextInt();
        Product p = productDAO.findById(productId);
        System.out.println("Before : "+ p);
        while(true) {
            System.out.println("Would you like to update the price or product description" +
                    "\n To update price enter 1\n To update Product Description enter 2\n To exit enter 3");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("Enter the new price");
                double newPrice = scanner.nextDouble();
                p.setMsrp(newPrice);
                productDAO.update(p);
                System.out.println("After : " + p);
            } else if (choice == 2) {
                System.out.println("Enter the new product description");
                String description = scanner.next();
                scanner.nextLine();
                p.setProductDescription(description);
                productDAO.update(p);
                System.out.println("After : " + p);
            }else if(choice == 3){
                break;
            }else {
                System.out.println("The choice you entered is invalid");
            }
        }



    }
}
