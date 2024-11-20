package org.perscholas;

import java.util.Scanner;

public class StringNullExample {
    public static void main(String[] args) {
        String s = null;// this string doesnot exist
        String s1 = "";//string exist but its empty
        // functions can be called on s1 because its real object
        // we cannot call functions
        //System.out.println(s1.split());
        if(s==s1){
            //this is always wrong
        }
        if(s!=null&& s.equals(s1)){
            System.out.println("will never print because null is not equal to empty string 1");
        }
        else{
            System.out.println("null is not equal to empty string 1");
        }
        if (s1.equals(s)) {

            //this works
            System.out.println("will never print because null is not equal to empty string 2");
        }
        else {
            System.out.println("null is not equal to empty string 2");
        }
        String s2;
        System.out.println("Enter a string");
        Scanner scanner = new Scanner(System.in);
        s2 = scanner.nextLine();
        System.out.println(s2.length());
    }
}
