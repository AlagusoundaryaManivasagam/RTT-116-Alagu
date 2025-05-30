package M;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Insertionsort {
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
        for(int i = 1; i < nums.size(); i++) {
            int index = i;
            int value = nums.get(i);
            boolean swap = false;
            for (int j = i-1; j>=0; j--) {
                if(value < nums.get(j)) {
                    int jv = nums.get(j);
                    nums.set(j, value);
                    nums.set(index, jv);
                    index--;
                    swap = true;
                }
                if(swap == false) {
                    break;
                }
            }
            System.out.println("sorted :" + nums);
        }
    }

}
