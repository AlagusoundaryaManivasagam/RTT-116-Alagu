package M303_9;

public class Circle extends Shape{
    private double radius;// each circle object gets its own memoryfor radius
    private static double PI = 3.14159;// there is only one PI variable for all circle objects

    public static double getPI() {
        return PI;
    }

    public static void setPI(double PI) {
        Circle.PI = PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*radius;
    }
}
