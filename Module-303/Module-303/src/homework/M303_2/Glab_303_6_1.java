package homework.M303_2;

import java.util.Scanner;

public class Glab_303_6_1 {
    public static void main(String[] args) {
        int age[]={12,4,5,2,5};
        System.out.println("Accessing the elements of array");
        System.out.println("First element : "+age[0]);
        System.out.println("Second element : "+age[1]);
        System.out.println("Third element : "+age[2]);
        System.out.println("Fourth element : "+age[3]);
        System.out.println("Fifth element : "+age[4]);
        System.out.println("============================================================================");
        int age1[]={12,4,5};
        System.out.println("Accessing array elements using for loop");
        for(int i=0; i<age1.length;i++){
            System.out.println(age1[i]);
        }
        System.out.println("===============================================================================");
        String[] names = {"NewYork","Dallas","LasVegas","Florida"};
        for(String name : names){
            System.out.println(name);
        }
        System.out.println("===============================================================================");
        int[] numbers = {-12,5,9,3,7,5,9,10,7,8,3,1};
        int sum=0;
        double average;
        for(int number: numbers){
            sum+=number;
        }
        int length = numbers.length;
        average = (double)sum/(double)length;
        System.out.println("The sum of the array is: "+sum);
        System.out.println("The average of the array is : "+average);
        System.out.println("===============================================================================");
        int[] marks={74, 43, 58, 60, 90, 64, 70};
        int sum1 = 0;
        int sumsq = 0;
        double mean,stddv;
        for(int mark:marks){
            sum1 = sum1+mark;
            sumsq= sumsq+(mark*mark);
        }
        mean= (double)sum1/(double)marks.length;
        stddv = Math.sqrt((double)sumsq/marks.length - (mean*mean));
        System.out.printf("Mean is:%.2f%n",mean);
        System.out.printf("Standard Deviation is:%.2f%n",stddv);
        System.out.println("===============================================================================");
        int i;
        int[] array = new int[11];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 elements");
        for( i=0;i<10;i++){
            array[i] = scanner.nextInt();
        }
        System.out.println("Now enter the element to insert");
        array[10] = scanner.nextInt();
        System.out.println("The new array is:");
        for(i=0;i<11;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("===============================================================================");



    }
}
