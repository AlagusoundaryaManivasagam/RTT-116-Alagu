package org.perscholas;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
      /*  System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        int x=scanner.nextInt();
        System.out.println("The number is "+x);
        System.out.println("Enter a name");
        char a=scanner.next().charAt(0);
        System.out.println("The name is "+a);
        System.out.println("Enter a word");
        String word=scanner.next();
        System.out.println("The word is "+word);*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = scanner.nextDouble();
        //after reading a number if to use nextLine() method use a nextLine() method as a buffer
        scanner.nextLine();
        System.out.println("You have entered the radius of " + radius + ".");
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle is " + area);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println( name );
        scanner.close();

    }
}
