package M303_5;

public class WhileLoop {
    public static void main(String[] args) {
       /* this is an infnite loop
        while(true) {
            System.out.println("Hello World");
        }*/
        // while loopshave condition and can be used instead of a for loop
        // for loop is better
        String word = "abcdef";
        int counter = 0;
        while (counter < word.length()) {
            System.out.println("inside while loop");
            counter++;
        }
        //great example for use of while loop
       /* boolean success = false;
        while (!success) {
           if(apicall ==true){
            }
         }
        */
        // while loop can remove the need for if because it also uses condition
        // do while loop let the code run once before testing the condition
        // for loop is the most used and while loop is used less and do while loop is least used
        int x = 0;
        do{
            x++;
            System.out.println("inside do while loop");
        }while(x<5);
    }
}
