package M303_7;

public class Average {
    public static void main(String[] args) {
        double[] values = {1.2,5.9,3.8,4.9};
        double sum=0;
        double average = 0;
        for(double number: values) {
            sum= sum + number;
        }
        average = sum/values.length;
        System.out.println("Average is "+average);
    }
}
