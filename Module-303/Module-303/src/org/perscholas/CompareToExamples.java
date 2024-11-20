package org.perscholas;

import java.util.ArrayList;
import java.util.List;

public class CompareToExamples {
    public static void main(String[] args){
        String s1 ="abc";
        String s2 = "xyz";
        System.out.println(s1.compareTo(s2));
        List<String> l1 = new ArrayList<>();
        l1.add("abc");
        l1.add("xyz");
        List<String>l2 = new ArrayList<>();
        l2.add("123");
        l2.add("456");

        System.out.println();
    }
}
