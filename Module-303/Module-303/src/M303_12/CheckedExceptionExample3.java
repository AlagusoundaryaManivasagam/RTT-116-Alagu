package M303_12;

public class CheckedExceptionExample3 {
    public void start() throws CustomException {
        method1();
    }

    public void method1() throws CustomException {

        System.out.println("method1");
        method2();
        throw new CustomException("Error in method 2");
    }

    //this forces method1 where method 2 is called
    //1. try block catch
    //throw error
    public void method2(){
        System.out.println("method 2");


    }
    public static void main(String[] args) throws CustomException {
        CheckedExceptionExample3 cee = new CheckedExceptionExample3();
        cee.start();
    }
}
