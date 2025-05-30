package M;

public class LeetCode3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        int i=0;
        int l = 1;
        for(int j =1; j<s.length();j++){
            if(!s.substring(i,j).contains(""+s.charAt(j))){
                l = Math.max(l,(j-i+1));
            }else{
                i++;
                j--;
            }
        }
        System.out.println(l);

    }
}
