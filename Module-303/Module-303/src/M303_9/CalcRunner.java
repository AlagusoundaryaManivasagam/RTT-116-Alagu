package M303_9;

import java.util.ArrayList;
import java.util.List;

public class CalcRunner {
    public static void main(String[] args) {
        Circle c = new Circle();
        c.setRadius(10);
        c.setName("Circle");

        Circle c1 = new Circle();
        c1.setRadius(15);
        c1.setName("Circle1");

        Triangle t = new Triangle();
        t.setHeight(10);
        t.setBase(10);
        t.setName("Triangle");

        //make a list of shapes but we are using the parent shape
        //in an indirect way when we add individual shapes to the list, they are typecasted automatically
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(c);
        shapes.add(c1);
        shapes.add(t);

        //loop over all the shapes
        for(Shape s: shapes){
            double area = s.calculateArea();
            double perimeter = s.calculatePerimeter();
            //when something has been typecasted to its parent still we can check to see which class'sobject it is
            if(s instanceof Triangle){
                System.out.println("s is of type triangle");
            }
            System.out.println("The area for shape "+ s.getName()+" is "+ area);
            System.out.println("The perimeter for shape " + s.getName()+ " is "+ perimeter);

        }
    }
}
