package M;

public class LeetCode169 {
    public static void main(String[] args) {
    int[] nums = {2,2,3,3,3,3,2};
        int n= nums.length;
        int r = nums[0];
        int m = 1;
        int left = 0;
        int right = n-1;
        while(left<right){
            if(nums[left] == nums[right]){
                m+=1;
            }

            if(right <= left+1){
                if(m>(n/2)){
                    System.out.println(nums[left]);
                }
                else{
                    left++;
                    right = n-1;
                }

            }else {
                right--;
            }
        }
        System.out.println(nums[0]);

    }}
