package org.perscholas;

public class WrapperClassExamples {
    public static void autobox(Integer x){
        System.out.println("Function called with"+ x);
    }
    public static void booleanAutobox(Boolean x){
        System.out.println("Function called with"+ x);
    }
    public static void main(String[] args) {
        int x=5;
        // this autoboxing/jvm automatically convert bn primitive and wrapper class.
        Integer y=x;
        //manual conversion of primitive to wrapper class
        Integer z=Integer.valueOf(x);
        // calling a function even though function calls Integer objects still we can use int to call the function
        autobox(5);
        autobox(x);
        autobox(y);
        autobox(z);
        // calling booleanAutobox with Boolean and boolean
        Boolean b1= true;
        boolean b2 = false;
        booleanAutobox(b1);
        booleanAutobox(b2);

        //java objects can be null
        Integer value =null;
        // a primitive can be null
        //int v1= null;
        // String uses
        String s1= "String 1";
        char c= 'e';
        Character c1=c;
        char c2 = c1.charValue();
        System.out.println("char value is "+c2);

    }
}
