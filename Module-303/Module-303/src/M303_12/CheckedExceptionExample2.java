package M303_12;

public class CheckedExceptionExample2 {

    //This throws exception to top upto main method
    public void start() throws CustomException {
        method1();
    }

    public void method1() throws CustomException {
        System.out.println("method1");
        method2();
    }

    //this forces method1 where method 2 is called
    //1. try block catch
    //throw error
    public void method2()throws CustomException{
        System.out.println("method 2");
        throw new CustomException("Error in method 2");

    }
     public static void main(String[] args) throws CustomException {
        CheckedExceptionExample2 cee = new CheckedExceptionExample2();
        cee.start();
     }
}
