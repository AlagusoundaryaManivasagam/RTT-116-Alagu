package M;

import java.util.Arrays;

public class LeetCode274 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 0; i<n;i++){
            if(citations[i]>= n-i){
                System.out.println(n-i);
            }
        }
        System.out.println(0);}
}
