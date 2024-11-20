package M303_6;

import java.util.Arrays;

public class DynamicArray {

    public static double[] bubbleSort(double[] array){
        for(int i = 0;i<array.length-1;i++){
            for(int j=0; j<(array.length-i-1); j++){
                if(array[j]>array[j+1]){
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


    public static double[] insert(double[] array, int position, double value) {
        if (position >= array.length - 1 || (position < 0)) {
            return array;
        }
        double[] result = new double[array.length + 1];
        //copy all elements from zero to the position where we wanna insert the new number
        for (int i = 0; i < position; i++) {
            result[i] = array[i];
        }
        // step 2
        // we set the incoming value at the insert position
        result[position] = value;
        //step 3
        // move all remaining values to the end of new array
        for (int i = position; i < array.length; i++) {
            result[i + 1] = array[i];
        }

        return result;
    }

    public static double[] delete(double[] array, int position) {
        // to check if the position is within the array
        if (position >= array.length - 1 || (position < 0)) {
            return array;
        }
        //step1 create a new array that is 1 smaller
        double[] result = new double[array.length - 1];
        // step 2
        //copy all values from 0 to position to the new array
        for (int i = 0; i < position; i++) {
            result[i] = array[i];
        }
        //step 3 shift remaining values
        for (int i = position + 1; i < array.length; i++) {
            result[i - 1] = array[i];
        }
        return result;

    }

    public static double[] apend(double[] array, double value) {
        //adding a number to the last index
        double[] result = new double[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }
        result[array.length] = value;
        return result;
    }

    public static void main(String[] args) {
        double[] numbers = {1, 7, 8, 4, 5, 6, 2, 9, 3, 10};
        numbers = insert(numbers, 3, 3.5);
        for(double d: numbers) {
            System.out.print(d+"  ");
        }
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println();
        System.out.println("=======================================================");
        numbers = delete(numbers, 8);// this will delete value 8 from array
        for(double d: numbers) {
            System.out.print(d+"  ");
        }
        System.out.println(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println();
        System.out.println("========================================================");
        numbers = apend(numbers, 15);
        for(double d: numbers) {
            System.out.print(d+"  ");
        }
        System.out.println(numbers);
        System.out.println(numbers.toString());
        System.out.println();
        System.out.println("========================================================");
        numbers = bubbleSort(numbers);
        for(double d: numbers) {
            System.out.print(d+"  ");
        }
        System.out.println();
        System.out.println(numbers);
        System.out.println(numbers.toString());
        System.out.println("========================================================");


    }
}
