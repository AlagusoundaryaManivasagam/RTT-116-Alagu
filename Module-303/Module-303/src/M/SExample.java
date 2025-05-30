package M;

public class SExample {
    public static void main(String[] args) {
        String s = "abcdefghijklmno";
        int k= 2;
        char[] a = s.toCharArray();
        for(int i=0; i< a.length; i+=((2*k)-1)){
            int j =( i+k-1);
            while(i<j){
                char t = a[i];
                a[i] = a[j];
                a[j]= t;
                i++;
                j--;
            }
        }

        System.out.println(new String(a));



}}
