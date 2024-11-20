package M303_8;

public class Runner {
    public static void main (String[]args){
        Square s1 = new Square();
        System.out.println(s1.toString());
        System.out.println("The perimeter is" + s1.calculatePerimeter());
        System.out.println("The area is" + s1.calculateArea());


        Square s2 = new Square(10, 20);
        s2.getWidth();
        System.out.println(s2);
        System.out.println(s2.toString());
        System.out.println("The perimeter is" + s2.calculatePerimeter());
        System.out.println("The area is" + s2.calculateArea());

        Square s3 = new Square(5,18);
        System.out.println(s3.toString());
        System.out.println("The perimeter is" + s3.calculatePerimeter());
        System.out.println("The area is" + s3.calculateArea());
        //s3.notAvailable();
        s3.partlyAvailable();




    }
}
