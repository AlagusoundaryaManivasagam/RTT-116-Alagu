package M303_9;

public abstract class Shape implements AreaCalculation {
    private String name;

    //we have twodiff techniques for accomplishing polymorphic behaviour
    // 1) by using an interface and allowing child classes to implement
    // 2) by using an abstract method that allows child classes to implement

    //this is another way of declaring something that the children must implement
    //child classes must implement the abstract method in parent class
    public abstract double calculatePerimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
