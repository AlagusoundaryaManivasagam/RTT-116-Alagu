package M;

import java.util.Arrays;

public class LeetCode238 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        int n = nums.length;
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        for(int i =1; i<n; i++){
            prefix[i] = prefix[i-1]* nums[i-1];
        }
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i = n-2; i>=0 ; i--){
            suffix[i] = suffix[i+1]* nums[i+1];
        }
        int answer[] = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = prefix[i]*suffix[i];
        }
        for(int a : answer){
            System.out.println(a+ " ");

        }
       }
}
