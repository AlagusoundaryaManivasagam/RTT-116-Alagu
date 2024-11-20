package M303_8;

public class Square {
    // height and width are class members or class variables
    // they are declared as private variables, hence we need getters and setters method
    // brtter practise to declare variables as private or protected
    private int height;
    private int width;
    // we can use getters and setters to change values of member variables

    //no return type it returns an object, its for initialization
    public Square() {
        //This runs when ever the code contains new Square()
    }

    // constructor is overloaded
    public Square( int height, int width){
            this.height = height;
            this.width = width;
        }
    public Square(int side){
        height = side;
        width = side;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight(){
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth(){
        return width;
    }

        // This method is on all java objects. it is used to return a string representation of this object
        public String toString () {
            return "Square [width = " + width + "height =" + height + "]";
        }

        public int calculateArea(){
        return width * height;
        //int x=1;
            //this is unreachable
        }

        public int calculatePerimeter(){
        return (width*2) + (height*2);
        }
        private void notAvailable(){
    }
    protected void partlyAvailable(){

    }

    }



