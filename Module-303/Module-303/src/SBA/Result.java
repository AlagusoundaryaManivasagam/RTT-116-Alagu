package SBA;

public class Result {
    public static int getDigitsSum(int largeNumber) {
        int count=0;
        do{
            count = count+(largeNumber%10);
            largeNumber = largeNumber/10;
        }while(largeNumber>=10);
        return count;

    }

}
