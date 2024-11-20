package org.perscholas;

public class PrimitiveTypeCasting {
    public static void main(String[] args) {
        int x = 5;
        // y is an integer only a whole number will be stored
        int y= 5/2;
        System.out.println(y);
        //z is double but still we get similar answer because the division is bn two integers.
        double z = 5/2;
        System.out.println(z);
        // d is doule also the values are with decimals hence we get the accurate result.
        double d = 5/2.0;
        System.out.println("d="+d);
        //type casting
        double e = (double)5/(double)2;
        System.out.println(e);
        int j= 5;
        int k= 2;
        double h = (double)j/(double)k;
        System.out.println(h);
        double g = (double)j;
        System.out.println(g);

    }
}
