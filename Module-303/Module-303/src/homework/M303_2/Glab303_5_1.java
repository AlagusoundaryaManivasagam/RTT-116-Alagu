package homework.M303_2;

import java.util.Scanner;

public class Glab303_5_1 {
    public static void main(String[] args) {
        int n= 5;
        for(int i=1;i<=n;++i){
            System.out.println(i+ "Java is fun");
        }
        System.out.println("================================================================");
        int sum = 0;
        int n1= 1000;
        for(int i=1;i<=n1;++i){
            sum += i;
        }
        System.out.println("The sum is "+ sum);
        System.out.println("================================================================");
        String original, reverse="";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string/number to check if it's a palindrome");
        original = scanner.next();
        int length = original.length();
        for (int i= length -1;i>=0;i--){
            reverse = reverse+original.charAt(i);
        }
        if (original.equals(reverse)){
            System.out.println("Yes, it's a palindrome");
        }
        else{
            System.out.println("No, it's not a palindrome");
        }
        System.out.println("================================================================");
        for(int i=1;i<=5;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("================================================================");

    }
}
