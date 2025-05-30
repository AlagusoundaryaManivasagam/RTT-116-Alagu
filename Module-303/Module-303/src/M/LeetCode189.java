package M;

public class LeetCode189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k =3;
        int n = nums.length;
        if(n<k){
            for(int i=1;i<=k;i++){
                int temp = nums[n-1];
                for(int j=n-2;j>=0;j--){
                    nums[j+1] = nums[j];
                }
                nums[0] = temp;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
        }
        else {
            int[] s = new int[k];
            int j = 0;
            for (int i = n - k; i < n; i++) {
                s[j] = nums[i];
                j++;
            }
            for (int i = n - k - 1; i >= 0; i--) {
                nums[i + k] = nums[i];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = s[i];
            }
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
