package homework.M303_2;

import java.util.Scanner;

public class Glab303_3_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter three words seperated by spaces: ");
        String s1=scanner.next();
        String s2=scanner.next();
        String s3=scanner.next();
        System.out.println("s1 is "+s1);
        System.out.println("s2 is "+s2);
        System.out.println("s3 is "+s3);
        scanner.nextLine();
        System.out.println("==========================================================");
        System.out.println("Enter a character: ");
        String s4=scanner.nextLine();

        char ch= s4.charAt(0);
        System.out.println("The character entered is: "+ch);
        scanner.close();
    }
}
