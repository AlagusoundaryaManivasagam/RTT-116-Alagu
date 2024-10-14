package homework.Pa303_10_3;

public class LibraryInterfaceDemo {
    public static void main(String[] args){
        KidUser k1 = new KidUser();
        k1.registerAccount(10);
        k1.registerAccount(18);
        k1.requestedBook("Kids");
        k1.requestedBook("Fictions");
        AdultUser a1 = new AdultUser();
        a1.registerAccount(5);
        a1.registerAccount(23);
        a1.requestedBook("Kids");
        a1.requestedBook("Fiction");

    }
}
