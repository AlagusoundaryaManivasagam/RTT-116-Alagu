package Hackerrank44;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ClosedPaths {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String s = Integer.toString(number);
        int paths = 0;
        int[] array = new int[s.length()];
        for(int i = s.length()-1; i >=0; i--){
            if(number>=10){
                array[i] = number % 10;
                number = number/10;
            }else{
                array[i] = number;
            }
        }

        for(int i=0; i<array.length;i++){
            if(array[i]==0 || array[i]==4 ||array[i]==6 ||array[i]==9){
                paths = paths+1;
            }else if (array[i]==8){
                paths = paths + 2;
            }
        }
        System.out.println(paths);
    }
}
