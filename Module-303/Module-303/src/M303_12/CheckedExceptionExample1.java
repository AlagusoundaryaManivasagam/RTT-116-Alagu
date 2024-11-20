package M303_12;

public class CheckedExceptionExample1 {

    //This deals exception in start method
    public void start()  {

            method1();

    }

    public void method1()  {
        System.out.println("method1");

           method2();

    }

    //this forces method1 where method 2 is called
    //1. try block catch
    //throw error
    public void method2() {
        System.out.println("method 2");
        try {
            throw new CustomException("Error in method 2");
        } catch (Exception e) {

        }


    }
    public static void main(String[] args) {
        CheckedExceptionExample1 cee = new CheckedExceptionExample1();
        cee.start();

    }
}
