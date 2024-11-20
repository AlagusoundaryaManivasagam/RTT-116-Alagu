package org.perscholas;

import java.util.Scanner;

public class Practice3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String s = Integer.toBinaryString(number);
        System.out.println(s);
        int n = s.length();
        System.out.println(n);
        char ch =  s.charAt(n-4);
        int a = Integer.parseInt(String.valueOf(ch));
        System.out.println(a);
        System.out.println(String.valueOf(a));

    }
}
