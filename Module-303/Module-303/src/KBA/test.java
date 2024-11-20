package KBA;

public class test {
    public static void main(String[] args) {
        MyFunctionalInterface fi = n -> {
            return n*n;
        };
        System.out.println(fi.sqr(5));
    }
}
