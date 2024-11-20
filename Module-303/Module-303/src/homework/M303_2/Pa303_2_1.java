package homework.M303_2;

import java.text.DecimalFormat;

public class Pa303_2_1 {
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        int sum = a + b;
        System.out.println("Sum of integers is: " + sum);
        //============================================================
        double c = 4.0;
        double d = 7.0;
        double sum1 = c + d;
        System.out.println("Sum of double is: " + sum1);
        //=================================================================
        int e = 5;
        double f = 6.2;
        double sum2 = e + f;
        System.out.println("Sum of integer and double  is: " + sum2);
        //================================================================
        int g = 6;
        int h = 8;
        int division;
        if (g > h) {
            division = g / h;

        } else {
            division = h / g;

        }
        System.out.println("Division is: " + division);
        double g1 = 6.0;
        int h1 = 8;
        double division1;
        if (g1 > h1) {
            division1 = g / h;

        } else {
            division1 = h / g;

        }
        System.out.println("Division of double is: " + division1);
        //======================================================================
        double i = 7.8;
        double j = 9.3;
        double division2;
        if (i > j) {
            division2 = i / j;
        } else {
            division2 = j / i;
        }
        System.out.println("Division of double is: " + division2);
        System.out.println("Division of double casted as int is:" + (int) division2);
        //===========================================================================
        int x = 5;
        int y = 6;
        int q = y / x;
        System.out.println("The value of q is :" + q);
        double q1 = (double) y / x;
        System.out.println("The value of q is y casted into double is :" + q1);
        int radius = 2;
        double area;
        final double PI = Math.PI;
        area = radius * radius * PI;
        System.out.println("The area: " + area);
        //==============================================================================
        int coffee_price = 10;
        int cappuchino_price = 20;
        int expresso_price = 20;
        int subtotal;
        double totalsale;
        subtotal = 3 * coffee_price + 4 * cappuchino_price + 2 * expresso_price;
        final double SALES_TAX = 0.15;
        totalsale = subtotal + SALES_TAX * subtotal;
        DecimalFormat df= new DecimalFormat("0.00");
        System.out.println("The total sale is : " + df.format(totalsale));

    }
}
