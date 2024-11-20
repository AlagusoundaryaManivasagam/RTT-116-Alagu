package M303_6;

public class ArraysExamples {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        //array is initialized to zero
        //print all elements of the array
        //old style for loop
        for(int i = 0; i < numbers.length; i++){
            System.out.println("numbers["+i+"] = " + numbers[i]);
        }
        // to initialize the array we can just loop and add each index without hardcoding
        //hardcoding array initialization
        int[] numbers1 = {1,2,3,4,5,6};
        //this will create an array ofsize 5
        String[] strings = {"0ne","Two","Three","Four","Five" };
    }
}
