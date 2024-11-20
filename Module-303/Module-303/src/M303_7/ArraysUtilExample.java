package M303_7;

import java.util.Arrays;

public class ArraysUtilExample {
    public static void main(String[] args) {
        // this line creates a new array of size 10
        double[] dValues = new double[10];
        // this fills all values with 50
        Arrays.fill(dValues, 50.0);
        //This doesnt work
        //System.out.println(dValues);
        System.out.println(Arrays.toString(dValues));
    }
}
