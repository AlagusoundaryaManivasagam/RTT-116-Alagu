package homework.M303_2;

public class Glab303_2 {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;
        System.out.println("x & y : " + (x & y));
        System.out.println("x && y : " + (x && y));
        System.out.println("x | y : " + (x | y));
        System.out.println("x || y: " + (x || y));
        System.out.println("x ^ y : " + (x ^ y));
        System.out.println("!x : " + (!x));
        int a = 58; //111010
        int b =10;
        System.out.println("a & b : " + (a & b));
        System.out.println("a | b : " + (a | b));
        System.out.println("a ^ b : " + (a ^ b));
        System.out.println("~a : " + (~a));  //-59
        System.out.println("a << b : " + (a << b));
        System.out.println("a >> b : " + (a >> b));
        int num= 15;
        String result= num>10? "The number is greater than 10":"The number is less than 10";
        System.out.println(result);
        int num2= 15;
        System.out.println("num2 : " + num2);
        num2++;
        System.out.println("num2++ : " + num2);
        ++num2;
        System.out.println("++num2 : " + num2);
        num2=-num2;
        System.out.println("num2 : " + num2);
        boolean fr= true;
        System.out.println("fr : " + (fr));
        fr=!fr;
        System.out.println("fr : " + (fr));
    }
}
