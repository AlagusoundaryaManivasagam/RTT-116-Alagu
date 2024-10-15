package homework.Glab303_10_4;

public class Rectangle extends Shape implements Movable{
    private int x,y;
   public Rectangle(int height, int width, int x, int y){
       super.height = height;
       super.width = width;
       this.x = x;
       this.y = y;
   }
   public Rectangle(String color){
       super.color = color;
   }

    @Override
    public double getArea() {
        return height*width;
    }
    public void displayShapeName(){
        System.out.println(" The shape is Rectangle");
    }
    public String toString(){
       return "Rectangle [ Height = "+ height +", Width = "+ width+ "]";
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
