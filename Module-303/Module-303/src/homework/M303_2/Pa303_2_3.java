package homework.M303_2;

public class Pa303_2_3 {
    public static void main(String[] args) {
        int x = 2;
        System.out.println(Integer.toBinaryString(x));
        x = x << 1;
        // predicted decimal value is 4 and predicted binary value is 100
        System.out.println(x);
        System.out.println(Integer.toBinaryString(x));
        System.out.println("================================================");
        int y = 9;
        System.out.println(Integer.toBinaryString(y));
        y = y << 1;
        //predicted  decimal value is 18 and predicted binary value is 10010
        System.out.println(y);
        System.out.println(Integer.toBinaryString(y));
        System.out.println("================================================");
        int z = 17;
        System.out.println(Integer.toBinaryString(z));
        z = z << 1;
        //predicted  decimal value is 34 and predicted binary value is 100010
        System.out.println(z);
        System.out.println(Integer.toBinaryString(z));
        System.out.println("================================================");
        int a = 88;
        System.out.println(Integer.toBinaryString(a));
        a = a << 1;
        //predicted  decimal value is 176 and predicted binary value is 10110000
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println("================================================");
        //============================================================================
        int x1 = 150;
        System.out.println(Integer.toBinaryString(x1));
        x1 = x1 << 2;
        //predicted decimal vale is 600 and  predicted binary value is 1001011000
        System.out.println(x1);
        System.out.println(Integer.toBinaryString(x1));
        System.out.println("================================================");
        int y1 = 225;
        System.out.println(Integer.toBinaryString(y1));
        y1 = y1 << 2;
        //predicted decimal vale is 900 and  predicted binary value is 1110000100
        System.out.println(y1);
        System.out.println(Integer.toBinaryString(y1));
        System.out.println("================================================");
        int z1 = 1555;
        System.out.println(Integer.toBinaryString(y1));
        z1 = z1 << 2;
        //predicted decimal vale is 6220 and  predicted binary value is 1100001001100
        System.out.println(z1);
        System.out.println(Integer.toBinaryString(z1));
        System.out.println("================================================");
        int a1 = 32456;
        System.out.println(Integer.toBinaryString(y1));
        a1 = a1 << 2;
        //predicted decimal vale is 129824 and  predicted binary value is 11111101100100000
        System.out.println(a1);
        System.out.println(Integer.toBinaryString(a1));
        System.out.println("================================================");
        //==================================================================================
        int x2 = 7;
        int y2 = 17;
        int z2 = x2 & y2;
        //predicted decimalvalue is 1 and binary value is 1
        System.out.println(z2);
        System.out.println(Integer.toBinaryString(z2));
        System.out.println("================================================");
        //====================================================================================
        int x3 = 7;
        int y3 = 17;
        int z3 = x2 | y2;
        //predicted decimal value is 23 and binary value is 10111
        System.out.println(z3);
        System.out.println(Integer.toBinaryString(z3));
        System.out.println("================================================");
        //====================================================================================
        int x4 = 5;
        System.out.println("value before increment" + x4);
        x4++;
        System.out.println("value after increment" + x4);
        System.out.println("================================================");
        //=======================================================================================
        int x5 = 7;
        System.out.println("value before increment" + x5);
        x5 += 1;
        System.out.println("value after adding 1" + x5);
        x5 = ++x5;
        System.out.println("value after prefix increment" + x5);
        x5 = x5++;
        System.out.println("value after postfix increment" + x5);
        System.out.println("================================================");
        //==============================================================================================
        int x6 = 5;
        int y6 = 8;
        int sum = ++x6 + y6;
        System.out.println("value of sum with prefix increment" + sum);
        int x7 = 5;
        int y7 = 8;
        int sum1 = x7++ + y7;
        System.out.println("value of x after post increment" + x7);
        System.out.println("value of sum with postfix increment" + sum1);


    }
}
