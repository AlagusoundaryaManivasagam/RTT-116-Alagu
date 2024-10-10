package Coffee_shop;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Coffee_shop {


    private Scanner scanner = new Scanner(System.in);

    //this is a class level variable that will contain our list of products forsale
    // best practice is to define these at the top of the class
    private List<Product> products = new ArrayList<>();
    private List<Product> cart = new ArrayList<>();

    private void initProducts() {
        Product p1 = new Product("Small Coffee", 4.57, 0);
        products.add(p1);
        Product p2 = new Product("Large Coffee", 7.99, 0);
        products.add(p2);
        Product p3 = new Product("Sugar Cookie", 5.99, 0);
        products.add(p3);
        Product p4 = new Product("Egg Sandwich", 6.99, 0);
        products.add(p4);
    }

    private void printProductMenu() {
        for (int count = 0; count < products.size(); count++) {
            Product p = products.get(count);

            System.out.println((count + 1) + ")" + p.getName() + "\t" + p.getPrice());
        }
        System.out.println();
    }

    private int printMainMenu() {
        System.out.println("1)See product menu");
        System.out.println("2)Purchase product");
        System.out.println("3) Checkout");
        System.out.println("4) Exit");
        System.out.println("\n Enter Selection :");
        try{
        int selection = scanner.nextInt();
            return selection;
        }
        catch ( Exception e){
            System.out.println("Invalid response "+ e.getMessage());
            return -1;
        }
        finally {
            scanner.nextLine();
        }

    }

    public void addProductToCart() {
        // display products for sale
        printProductMenu();
        //prompt user to enter an item to buy
        System.out.println("Enter a product number:");
        int selection = scanner.nextInt();
        scanner.nextLine();
        if(selection>=1 && selection<= products.size()) {
            //add product to cart
            Product p = products.get(selection - 1);
            cart.add(p);
            System.out.println("Added " + p.getName() + " to your cart.\n");
        }else{
            System.out.println("Invalid response");
        }
        //how may do you want to buy
        //make adjustment to quantity on product


    }

    public void checkout() {
        //List the items in the cart
        System.out.println("============= Items in your cart ==========");
        double subtotal = 0.0;
        for (Product item : cart) {
            System.out.println(item.getName() + " \t $" + item.getPrice());
            subtotal = subtotal + item.getPrice();
        }
        System.out.println();
        System.out.println("Subtotal\t\t $" + subtotal);
        //calculate tax
        double tax = subtotal * 0.09;
        System.out.println("Tax\t\t\t\t$" + tax);
        //calculate total amount
        double total = (subtotal + tax);
        System.out.println("Total\t\t\t $" + total + "\n");
    }


    public void start() {
        //this becomes similar to the main method in that it will be where our project starts and runs
        initProducts();

        //while repeat forever until 4 is given as input
        while (true) {
            int selection = printMainMenu();

            if (selection == 1) {
                //print product menu
                printProductMenu();

            } else if (selection == 2) {
                //purchae product/ add to cart
                addProductToCart();
            } else if (selection == 3) {
                //checkout
                checkout();
            } else if (selection == 4) {
                //exit
                System.out.println("Good Bye");
                // ends the program with status 0 i.e successful

                System.exit(0);

            }else {
                System.out.println(" Invalid command entered :"+ selection+"\n");
            }
        }

    }

    public static void main(String[] args) {
        Coffee_shop cs = new Coffee_shop();
        cs.start();
    }
}

