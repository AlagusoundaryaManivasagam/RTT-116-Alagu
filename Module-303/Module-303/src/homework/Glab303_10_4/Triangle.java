package homework.Glab303_10_4;

public class Triangle extends Shape implements Movable {
    private int x,y;
    public Triangle(int x, int y, int height, int base){
        this.x= x;
        this. y = y;
        super.height = height;
        super.base = base;
    }
    public double getArea(){
        return (0.5* base* height);

    }
    public void didplayshapName(){
        System.out.println(" The shape is a triangtle");
    }
    public String toString(){
        return "Rectangle = [ Height = "+height+ ", Base = "+ base+" ]";
    }
    public String getCoordinate()
    {
        return  "(" + x + "," + y + ")";
    }

    // Need to implement all the abstract methods defined in the interface Movable
    @Override
    public void moveUp() {
        y++;
    }
    @Override
    public void moveDown() {
        y--;
    }
    @Override
    public void moveLeft() {
        x--;
    }
    @Override
    public void moveRight() {
        x++;
    }

}
