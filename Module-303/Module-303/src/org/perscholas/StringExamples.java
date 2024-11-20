package org.perscholas;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringJoiner;

public class StringExamples {
    public static void main(String[] args) {
        // 0 based indexing is used in strings
        String s = "abcdef";
        // there are 6 characters but the position of last char is 5 because indexing is from 0.
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(5));
        //System.out.println(s.charAt(6)); This throws exception
        int length = s.length();
        System.out.println("the length of string is :" + length);
        System.out.println("The uppercase of string is :" + s.toUpperCase());
        String s1 = "gh";
        String sum = s.concat(s1);
        System.out.println(sum);
        String replace = "abc123";
        System.out.println(replace);
        System.out.println(replace.replace('a', 'c'));
        System.out.println(replace.replace("abc", "def"));
        System.out.println(replace.replaceAll("\\d", "e"));
        //==================SUBSTRING================
        //================0123456789012==============
        String filename = "someimage.jpg";
        // This prints from 0 to 4 i.e upto 3 only 4 doesnt get printed
        System.out.println(filename.substring(0, 4));
        System.out.println(filename.substring(10, 12));
        //This goes from 4 till end
        System.out.println(filename.substring(4));
        //This gives error
        // System.out.println(filename.substring(10,15));
        // to print only the extensio
        // print the index of .
        //System.out.println("The . is in the position " + filename.indexOf('.'));
        //then we can get substring after the . position
        //instead we can do it directly
        System.out.println(filename.substring(filename.indexOf('.')));
        // last index of will find the last index of what char we are looking for.
        //i.e it is like its searching from right to left
        //so we can use substring and lastindex of
        System.out.println(filename.substring(filename.lastIndexOf('.')));
        System.out.println(filename.substring(0, filename.lastIndexOf('.')));
        //this will not work
        String a1 = "abc";
        String a2 = "abc";
        String a3 = new String("abc");
        String a4 = new String("abc");
        System.out.println(a1 == a2);
        System.out.println(a3 == a4);
        // always use only .equals method is correct
        System.out.println(a3.equals(a4));
        // this compares strings without case sensitivity
        String a5 = "ABC";
        System.out.println(a1.equals(a5));
        System.out.println(a1.equalsIgnoreCase(a5));
        // string to number
        String n = "101";
        //this is will take the string 101 and convert it to the number 101
        Integer n1 = Integer.parseInt(n);
        //parseint can throw exception if string is letters and not numbers
        //Integer n3 = Integer.parseInt("Abc");
        // number to string
        String n2 = n1.toString();
        System.out.println(n2);
        //=====important : String in java is immutable it cannot be changed
        String s4 = "abc";
        String s5 = "123";
        // s4.toUpperCase is called created new string in memory that is ABC
        // it did not modify s4
        //Then it concatinates on the string s5  when it creates another new string which is assigned to s6
        String s6 = s4.toLowerCase() + s5;
        //hence strings use lots of memory
        //to solve this string buffer is used. its mutable
        //String builder is similar to stringbuffer
        //potentialinterview question == why would you use a string buffer or string builder over a regular string
        //answer:  for memory management. string are immutable and jvm creates a new string in memory and then has to
        // garbage collect them whereas build and buffer are mutable and can be changed in memory and therfore efficient
        StringBuffer sb = new StringBuffer();
        System.out.println(sb);
        // this apend will add something toend of string and is same as concat
        sb.append("abc");
        System.out.println(sb);
        sb.append("123");
        System.out.println(sb);
        sb.insert(4, "xyz");//inserting at 4 th position because the indexing starts from 0
        System.out.println(sb);
        //replace function for String Buffer. 0 to 3 means uoto 3rd position but 3rd position is nottouched
        //starting at position 0 and to3 will be deleted and then six letters we are giving will be inserted at 0
        sb.replace(0, 3, "ABCDEF");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.reverse();
        sb.replace(3, 7, "1");
        System.out.println(sb);
        boolean b = true;
        sb.append(b);
        System.out.println(sb);
        sb.deleteCharAt(9);
        System.out.println(sb);
        System.out.println("========================================================");
        //=============================================================kba
        //eventhough kba has only 3 indexes and upto 7indexes are asked to remove it throws no error
        // it just removes 3 indexes and inserts the rest
        StringBuffer kba = new StringBuffer("ABC");
        kba.replace(0, 7, "DEFG").insert(0, "12345");//you can write methods next to each other
        //but its not readable
        kba.reverse();
        kba.delete(0, 5);
        System.out.println("kba =" + kba);
        System.out.println("============================================================");
        //==================================String Joiner============================kba
        StringJoiner sj1 = new StringJoiner("|", "{", "}");
        StringJoiner sj2 = new StringJoiner(":", "[", "]");
        sj1.add("Alagu");
        sj1.add("123");
        System.out.println(sj1);
        sj2.add("abc");
        sj2.add("ABC");
        System.out.println(sj2);// Stringjoiner formats list of string and seperates each one with a delimiter
        //But no delimiter at the end
        System.out.println(sj1.merge(sj2).toString());
        System.out.println("===============================================================");
        //=======================================formatting============================================
        int i = 1024;
        byte by = 127;
        double d = 1.232, tiny = d / 1000000.0;
        boolean bool = true;
        System.out.format(" This is an integer: %d and this is a byte: %d andone more variable %d \n", i, by, 10);
        System.out.format(" This is a double: %.4f and this is tiny: %.4e.\n", d, tiny);// f is format and e is exponent
        System.out.format(" And this is a String: %s", "This is a string.\n");
        //=============================Decimal formatting ===========
        //DecimalFormatter exsists and its easy to format a number nicely
        //it takes pattern and will apply that pattern to a number
        String pattern = "####,####.##";
        double number = 123456789.123;
        double number1 = 15.7893;

        DecimalFormat numberFormat = new DecimalFormat(pattern);

        System.out.println(number);

        System.out.println(numberFormat.format(number));
        System.out.println(numberFormat.format(number1));
        //=======================trim==================
        String t = "     abc123       ";
        System.out.println("->"+t+"<-");
        System.out.println("->"+t.trim()+"<-");
        //============================split============
     String vowels = "a::b::c::d:e";

     // splitting the string at "::"
     // storing the result in an array of strings
     String[] result = vowels.split("::");

     // converting array to string and printing it
     System.out.println("result = " + Arrays.toString(result));




    }
}
