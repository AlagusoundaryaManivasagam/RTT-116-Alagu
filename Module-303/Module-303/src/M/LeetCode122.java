package M;

public class LeetCode122 {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        int n = prices.length;
        int bp = prices[0];
        int profit =0;
        for(int i=0; i<n-1; i++){
            if(bp>prices[i]){
                bp = prices[i];
            }
            if(i == n-2){
                if(prices[i]<prices[i+1]){
                    profit += prices[i+1]-bp;
                }
                else{
                    profit += prices[i]-bp;
                    bp = prices[i+1];
                }
            }else if(bp<prices[i]){
                if(prices[i]<prices[i+1]){
                    continue;
                }
                profit += prices[i]-bp;
                bp = prices[i+1];
            }

        }
        System.out.println(profit);
    }
}
