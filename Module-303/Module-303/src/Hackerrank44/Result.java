package Hackerrank44;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static int getMinDeletions(String s) {
        // Write your code here
        int count =0;
        List<Character> array= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            array.add(s.charAt(i));
        }
        for(int i=0;i<array.size()-1;i++){
            for(int j =i+1; j<(array.size());j++){
                if(array.get(i).equals(array.get(j))){
                    array.remove(j);
                    count++;
                }
            }
        }
        return count;
    }
}
