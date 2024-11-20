package M303_7;

public class MinMaxArray {
    public static void main(String[] args) {
        int[] value = {1,8,5,2,9,7};
        //initialize to first elements in array to ensure that min and max values are within the array
        int min = value[0];
        int max = value[0];
        for(int v: value) {
            if (v < min) {
                min = v;
            }
            if (v > max) {
                max = v;
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
