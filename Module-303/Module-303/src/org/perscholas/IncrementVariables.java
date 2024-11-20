package org.perscholas;

public class IncrementVariables {
    public static void main(String[] args) {
        int a= 20;
        int b = 10;
        int c =0;
        int d = 20;
        int e= 40;
        int f = 30;
        int result = -a;
        System.out.println(result);
        c= b++;
        System.out.println(c);
        System.out.println(b);
        c=++a;
        System.out.println(c);
        System.out.println(a);
        System.out.println("The values of a,b,c,d,e,f are:"+ a+","+b+","+c+","+d+","+e+","+f);
        int finalAns= a++ +--b + ++c - --d + ++e - --f;
        System.out.println(finalAns);
        System.out.println("The values of a,b,c,d,e,f are:"+ a+","+b+","+c+","+d+","+e+","+f);
    }
}
