package homework.M303_2;

public class Pa303_5_1 {
    public static void main(String[] args) {
        int x = 12;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {
                System.out.printf("%5d",i*j);
            }
            System.out.println();
        }
        System.out.println("===================================================================");
        int n1 = 20;
        int n2 = 50;
        int k;
        int gcd=0;
        for ( k= 1; (k <= n1 && k <= n2); k++) {
            if(n1%k==0 && n2%k==0) {
                gcd =  k;
            }
        }
        System.out.printf("GCD of %d and %d is %d",n1,n2,gcd);
        System.out.println();
        System.out.println("====================================================================");
        double tuition = 10000;
        int i;
        for ( i = 1; tuition<=20000; i++) {
          tuition= tuition*1.07;
        }

        System.out.println("No. of years for tuition to double or more is"+ i);

    }
}
