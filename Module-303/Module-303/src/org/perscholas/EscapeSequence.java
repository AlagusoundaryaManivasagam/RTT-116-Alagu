package org.perscholas;

public class EscapeSequence {
    public static void main(String[] args) {
        //print - no new line, println -new line
        System.out.print("This is line 1\nThis is line 2\n");
        System.out.print("This is line 3\n");
        System.out.println("This is tab->\t<-");
        System.out.println("This is tab->1\t<-");
        System.out.println("This is tab->12\t<-");
        System.out.println("This is tab->123\t<-");
        System.out.println("This is tab->1234\t<-");
        System.out.println("print\"");
        System.out.println("print/");
        System.out.println("print\\");
        String x= "abc";
        System.out.println(x.toUpperCase());
        System.out.println("abc\b");
        System.out.println("abc\r def");
        System.out.println("abc\fdef");
        System.out.println("\f");
        System.out.println("1\r2");
    }
}
