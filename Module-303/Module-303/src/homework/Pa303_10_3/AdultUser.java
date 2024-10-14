package homework.Pa303_10_3;

public class AdultUser implements LibraryUser{
    int age;
    String bookType;
    public void registerAccount(int age){
        if( age>= 12){
            System.out.println("You have successfully registered under an Adult Account");
        }
        else if(age<= 11){
            System.out.println("Sorry, age must be greater than 12 to register as an adult.");
        }
    }
    public void requestedBook(String bookType){
        if( bookType == "Fiction"){
            System.out.println("Book Issued successfully, please return the book within 7 days.");
        }
        else{
            System.out.println("Oops, you are allowed to take only adult Fiction books.");
        }
    }
}
