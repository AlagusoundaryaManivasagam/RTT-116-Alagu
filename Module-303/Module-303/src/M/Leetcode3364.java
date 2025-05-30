package M;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode3364 {


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
        System.out.println("enter l");
        int l=scanner.nextInt();
        System.out.println("enter r");
        int r=scanner.nextInt();
        scanner.close();
        int n = nums.size();
        int [] prefix = new int[n];
        prefix[0] = nums.get(0);
        for(int i=1; i<n; i++){
            prefix[i] = prefix[i-1] + nums.get(i);
        }
        int sum = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            for(int j=0; j<n-i;j++){
                if(j == 0){
                    if(prefix[i-1]>0){
                        sum = Math.min(sum, prefix[i-1]);
                    }
                }else{
                    int sa = prefix[j+i-1] - prefix[j-1];
                    if(sa>0){
                        sum = Math.min(sum,sa);
                    }
                }
            }
        }
        System.out.println("min " + sum);

    }
}
