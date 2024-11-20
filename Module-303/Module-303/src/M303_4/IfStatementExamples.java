package M303_4;

import java.util.Scanner;

public class IfStatementExamples {
    public static void main(String[] args) {
        double radius = 30;
        if(radius>20){
            System.out.println("The radius is greater than 20");
        }
        else if(radius >10) {
            System.out.println("The radius is greater than 10");
        }
        else{
            System.out.println("The radius is less than or equal to 10");
        }
        System.out.println("Done");
        // if statement will always check if the condition is true
        // ifa boolean char is true the boolean is the condition in if statement then the block of code inside if is
        // gonna execute
        boolean save= true;
        if(save){
            //this will work
        }
        if (!save){
            //this will not work
        }
        //compound conditional
        //short circuiting i.e if first condition is right only the second one is evaluated
        //if first condition is false the entire thing is wrong so no need to evaluate the second one
        if(save&&(radius == 50)){
            //both are true so this will work
        }
        else{
            // when one is wrong this gets executed
        }
        // double or also short circuits i.e if first condition is true no need to check second one
        //only if first condition is false second condition is checked
        if(save||(radius==50)){
            //if either(or both) condition is true if block is executed
        }
        else{
            //if both are false then else block is executed
        }
        int grade = 30;
        if(grade>=90){
            System.out.println("A");
        }else if(grade>=80){
            System.out.println("B");
        }else if(grade>=70){
            System.out.println("C");
        }else if(grade>=60){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
        //switch uses a variable
        switch (grade){
            case 90: System.out.println("A");break;
            case 80: System.out.println("B");break;
            case 70: System.out.println("C");break;
            case 60: System.out.println("D");break;
            default: System.out.println("F");
        }
    }
}
