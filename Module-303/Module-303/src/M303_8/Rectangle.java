package M303_8;

public class Rectangle {
    private int height;
    private int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle(10, 20);
        System.out.println(r.getHeight());
        System.out.println(r.getWidth());

    }
}
