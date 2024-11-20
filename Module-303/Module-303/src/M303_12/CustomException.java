package M303_12;

public class CustomException extends Exception {
    // when working with custom exception is to end words with exception
    // we create a constructor and takes a string and calls super to initialize the parent
    public CustomException (String message){
        super(message);
        // This just uses the input and initialize the parent Exception class
    }
}
