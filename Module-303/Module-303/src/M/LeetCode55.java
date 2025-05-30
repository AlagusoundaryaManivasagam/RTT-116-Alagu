package M;

public class LeetCode55 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int n = nums.length;
        boolean ans = false;
        for(int i=0; i<n; i++){
            if(nums[i]==(n-i-1)){
                ans = true;
            }
        }
        System.out.println(ans);
    }
}
