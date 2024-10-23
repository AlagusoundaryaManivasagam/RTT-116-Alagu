package Coffee_shop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Coffeshop {
    //q.setQuantity(q.getQuantity + quantity);
    //when adding an item to the cart ... first increment the quantity on the product by the
    // amount that the person wanted to order ... then loop over the list of items in the cart
    // and if the item is not in the cart then you add to the cart
    // check length of strings and lpad

    private final DecimalFormat df = new DecimalFormat("0.00");

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
        Product p5 = new Product("Ginger Cookie", 5.99, 0);
        products.add(p5);

        //the original list can be modified by using sort
        products.sort(Comparator.comparing(Product::getName));
        products.forEach(e-> System.out.println(e));
        System.out.println("===============================================");

        // sort the list by price
        // we need to catch this list in a list because stream cannot modify the list
        //todo-homework write this function using for loop with bubblesort algorithm
        //todo homework create a new main menu option that allows to search list of products for a user entered name
        System.out.println("==========sort by stream===========");
        List<Product> sorted = products.stream().sorted(Comparator.comparing(Product::getPrice)).toList();
        sorted.forEach(e-> System.out.println(e));

        System.out.println("==========sort by bubble sort=======");
        List<Product> bubbleSort = bubbleSort(products);
        bubbleSort.forEach(e-> System.out.println(e));
        System.out.println("========================================");


        //overwrite the original products list with our new sorted list
        //products = sorted;

    }

    private void phraseSearch(String s){
        // this is a common technique to make both to lowercase and compare them to make the search process case insensitive
        List<Product> filteredList = products.stream().filter(e->e.getName().toLowerCase().contains(s.toLowerCase())).toList();
        //print list with a lambda is easy
        System.out.println("==========================================");
        filteredList.forEach(e-> System.out.println(e));
        System.out.println("==========================================");
        filteredList.forEach(e-> System.out.println(e.getName()+ "\t"+e.getPrice()));
        System.out.println("==========================================");

    }

    /*private List<Product> bubbleSort(List<Product> source) {

        for(int outer=0;outer<source.size()-1;outer++) {
            for(int inner =outer+1; inner<source.size();inner++) {
                Product p0 = source.get(outer);
                Product p1 = source.get(inner);
                if(p0.getPrice() > p1.getPrice()) {
                    source.set(inner, p0);
                    source.set(outer, p1);
                }
            }
        }
        return source;
    }*/
    private List<Product> bubbleSort(List<Product> source){
        for(int i = 0;i<source.size()-1;i++){
            for(int j=0; j<(source.size()-i-1); j++){
                Product p0 = source.get(j);
                Product p1 = source.get(j+1);
                if(p0.getPrice()>p1.getPrice()){
                    source.set((j+1), p0);
                    source.set(j, p1);
                }
            }
        }
        return source;
    }

    private void printProductMenu() {
        for (int count = 0; count < products.size(); count++) {
            Product p = products.get(count);

            System.out.println((count + 1) + ")" + p.getName() + "\t" + p.getPrice());
        }
        System.out.println();
    }

    private int printMainMenu() throws InvalidException {
        System.out.println("1) See product menu");
        System.out.println("2) Purchase product");
        System.out.println("3) Checkout");
        System.out.println("4) Search with phrase");
        System.out.println("5) Exit");
        if (!cart.isEmpty()){
            System.out.println("6) Would you like to add/remove an item to your cart?");
        }

            return readNumberFromUser("Enter selection : ");

    }

    private int readNumberFromUser(String question)throws InvalidException{
        //by adding throws clause here I am saying this function can throw an
        // exception called InvalidException
        //By using throw a checked exception we are forcing every place in code that are
        // calling this method to deal with it
        System.out.println(question);

        try {
            int selection = scanner.nextInt();
            return selection;
            // This is interesting wrinkle, java will call the finally block even after the return statement because
            // return is inside try block
        }catch (Exception e){
            System.out.println("Invalid input from here: "+e.getMessage());
            throw new InvalidException("Invalid input: "+ e.getMessage());
            //return -1;
            // this is logic we are adding to just know that there was a problem
            //not recommended always
        }finally {
            scanner.nextLine();
        }


    }

    public void addProductToCart() {
        // display products for sale
        printProductMenu();
        //prompt user to enter an item to buy


        try {
            int selection = readNumberFromUser("Enter a product number:");

            if (isProductSelectionValid(selection)) {

                int quantity = readNumberFromUser(" How many would you like to order?");
                //add product to cart
                if (quantity <= 0) {
                    System.out.println("Must buy atleast one item");
                } else {
                    Product p = products.get(selection - 1);
                    p.setQuantity(p.getQuantity() + quantity);
                    if (!existsInCart(p)) {
                        cart.add(p);

                    }

                    System.out.println("Added " + quantity + " " + p.getName()+ " to your cart.\n");
                }

            } else {
                System.out.println("Invalid response");
            }
        }catch (InvalidException ie){
            System.out.println("=======Here===========");
        }

        //how may do you want to buy
        //make adjustment to quantity on product


    }

    private boolean isProductSelectionValid(int selectedProduct){
        if(selectedProduct>=1 && selectedProduct<=products.size()){
            return true;
        }
        else {
            return false;
        }
    }

    private boolean existsInCart(Product purchase) {
        boolean found = false;
        for (Product item : cart) {
            //if name of product purchase is equal to any name in cart list then
            // the product is already added
            if (item.getName().equals(purchase.getName())) {
                found = true;
                break;
            }
        }
        return found;
    }

    public void removeItem() throws InvalidException {
        System.out.println("============= Items in your cart ==========");
        double subtotal = 0.0;

        System.out.println("Item name\t\t\tPrice\t\tQuantity\t\tTotal price");

        for(int i=0; i<cart.size(); i++){
            System.out.println((i+1) + ") "+ cart.get(i).getName() + " \t\t " + cart.get(i).getPrice() + "\t\t" + cart.get(i).getQuantity() + "\t\t\t$" +
                    df.format(cart.get(i).getPrice() * cart.get(i).getQuantity()));
        }

        System.out.println();

       int itemNo = readNumberFromUser("Which item would you like to remove?");
       int itemQuantity = readNumberFromUser("How many items would you like to remove?");
        for(int i=0; i<cart.size(); i++){
            if((i+1) == itemNo){
                if((cart.get(i).getQuantity()) == itemQuantity) {
                    cart.remove(i);
                    System.out.println("The item has been removed");
                    break;
                }
                else if((cart.get(i).getQuantity()) > itemQuantity){
                    cart.get(i).setQuantity(cart.get(i).getQuantity() - itemQuantity);
                    System.out.println(itemQuantity+" "+cart.get(i).getName() + " has been removed from your cart");
                    break;
                }
                else{
                    System.out.println("The number you entered is invalid");
                }
            }
            else{
                System.out.println("There is no such item in the cart");
            }
        }
    }


    public void checkout() {
        //List the items in the cart
        System.out.println("============= Items in your cart ==========");
        double subtotal = 0.0;

        System.out.println("Item name\t\t\tPrice\t\tQuantity\t\tTotal price");

        for (Product item : cart) {

                System.out.println(item.getName() + " \t\t " + item.getPrice() + "\t\t" + item.getQuantity() + "\t\t\t$" + df.format(item.getPrice() * item.getQuantity()));
                subtotal = subtotal + item.getPrice() * item.getQuantity();
        }
        System.out.println();
        System.out.println("Subtotal\t\t $" + df.format(subtotal));
        //calculate tax
        double tax = subtotal * 0.09;
        System.out.println("Tax\t\t\t\t$" + df.format(tax));
        //calculate total amount
        double total = (subtotal + tax);
        System.out.println("Total\t\t\t $" + df.format(total) + "\n");
    }


    public void start()  {
        //this becomes similar to the main method in that it will be where our project starts and runs
        initProducts();

        //while repeat forever until 4 is given as input
        while (true) {
            try {
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
            }else if(selection == 4){
                // ask for search phrase
                System.out.println("Enter a phrase to search");
                String phrase= scanner.nextLine();
                phraseSearch(phrase);

            } else if (selection == 5) {
                //exit
                System.out.println("Good Bye");
                // ends the program with status 0 i.e successful

                System.exit(0);

            }else if(selection == 6){
                removeItem();
            }
            else {
                System.out.println(" Invalid command entered :" + selection + "\n");
            }
        }
        catch(InvalidException e ){
            System.out.println("Invalid selection");
        }

    }}

    public static void main(String [] args)  {
        Coffeshop cs = new Coffeshop();

            cs.start();

    }
}
