package homework.M303_2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.stream;

public class Pa303_7_1 {
    public static void main(String[] args) {
        int[] numbers = new int[3];
        numbers[0] = 1;
        numbers[1] = 2;
        numbers[2] = 3;
        for(int i=0; i<numbers.length; i++){
            System.out.println(numbers[i]);
        }
        System.out.println("==================================================================");
        int numbers1[] ={13,5,7,68,2};
        int length = numbers1.length;
        int midArray = (length)/2;
        System.out.println(numbers1[midArray]);
        System.out.println("==================================================================");
        String[] words = {"red", "green", "blue","yellow"};
        System.out.println(words.length);
        String[] clonedWords = words.clone();
        for(String word : clonedWords){
            System.out.println(word);
        }
        System.out.println("==================================================================");
        int[] numbers2= {1, 8, 9, 5, 2};
        System.out.println("The first and last value of the array is "+numbers2[0]+" and "+numbers2[numbers2.length-1]);
        //System.out.println(numbers2[numbers2.length]);
        //this throws the exception.ArrayIndexOutOfBoundsException
        //System.out.println(numbers2[5]);
        //This throws the exception .ArrayIndexOutOfBoundsException
        System.out.println("==================================================================");
        int[] numbers3 = new int[5];
        for(int i=0; i<numbers3.length; i++){
            numbers3[i] = i;
        }
        for(int num: numbers3){
            System.out.println(num);
        }
        System.out.println("==================================================================");
        int[] numbers4 = new int[5];
        for(int i=0; i<numbers4.length; i++){
            numbers4[i] = i*2;
        }
        for(int num: numbers4){
            System.out.println(num);
        }
        System.out.println("==================================================================");
        int[] numbers5 = {4,9,2,10,8};
        for(int i=0; i<numbers5.length; i++){
            if(i!=(numbers5.length/2)){
                System.out.println(numbers5[i]);
            }
        }
        System.out.println("==================================================================");
        String[] array = {"red", "green", "blue", "yellow","orange"};
        System.out.println("Before swap");
        for(String s : array){
            System.out.println(s);
        }
        array[0] = array[0]+ array[3];
        array[3] = array[0].substring(0,(array[0].length()-array[3].length()));
        array[0] = array[0].substring(array[3].length());
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
        System.out.println("==================================================================");
        int[] numbers6 = {4, 2, 9, 13, 1, 0};
        Arrays.sort(numbers6);
        System.out.println("Array in ascending order:"+ Arrays.toString(numbers6));
        System.out.println("The biggest number is "+stream(numbers6).max().getAsInt());
        System.out.println("The smallest number is "+stream(numbers6).min().getAsInt());
        System.out.println("==================================================================");
        Object[] arr = new Object[5];
        arr[0] = 5;
        arr[1] = new String("red");
        arr[2] = new String("green");
        arr[3] = new String("blue");
        arr[4] = (double) 8.0;
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println("==================================================================");
        int x;
        System.out.println("How many favourite things do you have?");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        String[] array1 = new String[x];
        for (int i=0; i<array1.length; i++){
            System.out.println("Enter your thing");
            array1[i] = scanner.next();
        }
        System.out.println("Your favourite things are:");
        String sentence = String.join(" ", array1);

        System.out.println(sentence);
        scanner.close();


    }
}
