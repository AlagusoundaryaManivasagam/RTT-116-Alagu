package M;

import java.util.Arrays;

public class Leetcode1984 {
    public static void main(String[] args) {
        int[] nums ={9, 7, 1, 4};
        int k=2;
        Arrays.sort(nums);
        int n= nums.length;
        int diff = Integer.MAX_VALUE;

        if(n == 1){
            diff = 0;
        }else{
        for(int i=0;i<n-k+1;i++ ){
            int d = nums[i+k-1] - nums[i];
            diff = Math.min(diff, d);
        }
        }

    }
}
