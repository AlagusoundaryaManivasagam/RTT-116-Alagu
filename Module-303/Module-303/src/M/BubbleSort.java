package M;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
    public static void main(SExample[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        System.out.println("Enter number to add or -0 to exit");
        while(true) {
            int num = scanner.nextInt();
            if (num != 0) {
                nums.add(num);
            }else{
                break;
            }
        }
        scanner.close();
        for(int i=0; i<nums.size()-1; i++){
            boolean swap = false;
            for(int j=0;j<nums.size()-i-1;j++){
                if(nums.get(j) > nums.get(j+1)){
                    int temp = nums.get(j);
                    int value = nums.get(j+1);
                    nums.set(j,value);
                    nums.set((j+1),temp);
                    swap = true;
                }
                }
            if(swap == false){
                break;
            }

            System.out.println("sorted :" + nums);

        }


    }
}
