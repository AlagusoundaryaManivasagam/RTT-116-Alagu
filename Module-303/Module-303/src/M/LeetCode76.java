package M;

import java.util.HashMap;

public class LeetCode76 {
    public static void main(String[] args) {
        String t = "abcdd";
        String s = "aaaaaaaaaaaabbbbbcdd";
        int n1= t.length();
        int n2 = s.length();
        String ans = "";
        if(n1>n2){
            System.out.println(ans);
        }



        HashMap<Character,Integer> m1 = new HashMap<>();
        for(int i=0; i<t.length();i++){
            m1.put(t.charAt(i),m1.getOrDefault(t.charAt(i),0)+1);
        }
        int length = Integer.MAX_VALUE;
        for(int i=0;i<n2;i++){
            if(m1.containsKey(s.charAt(i))){
                HashMap<Character,Integer> m2 = new HashMap<>();
                int j=i;
                while(j<n2){
                    if(m1.containsKey(s.charAt(j))){
                        m2.put(s.charAt(j),m2.getOrDefault(s.charAt(j),0)+1);
                        j++;
                    }else{
                        j++;
                    }
                    if(isM1EqualsM2(m1,m2)){
                        j--;
                        if(length >(j-i+1))
                        {   length = j-i+1;
                            if(j<n2-1){
                                ans = s.substring(i,j+1);
                            }else if(j == n2-1){
                                ans = s.substring(i);
                            }
                        }
                        break;
                    }
                }
            }
        }
        ans = ( length == Integer.MAX_VALUE ?"":ans);
        System.out.println(ans);

    }
    public static boolean isM1EqualsM2(HashMap<Character,Integer> map1,HashMap<Character,Integer>map2){
        for(Character key: map1.keySet()){
            if(!map2.containsKey(key)){
                return false;
            }
            if (map2.containsKey(key)) {
                if (map1.get(key) > map2.get(key)) {
                    return false;
                }
            }
        }
        return true;
    }
}
