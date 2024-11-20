package M303_9;

public class Runner {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10);// this is from circle class
        c.setName("Circle");// this is method of Shape class, circle inherits shape
        c.setPI(4);
        System.out.println(c.getName()+"="+ c.getPI());
        Shape s = (Shape) c;// child class object can be type casted to parent class object

        Circle c2 = new Circle();
        c2.setRadius(20);
        c2.setName("Circle2");
        c.setPI(5);
        System.out.println(c2.getName()+"="+ c2.getPI());
        System.out.println(c.getName()+"="+ c.getPI());// prints 5 because we changed the value to 5

        Triangle t = new Triangle();
        t.setBase(20);
        t.setHeight(20);
        t.setName("Triangle");


    }
}
