package homework.Pa303_10_3;

public interface LibraryUser {
    int age = 0;
    String bookName = "";

    void registerAccount(int age);
    void requestedBook(String bookName);
}
