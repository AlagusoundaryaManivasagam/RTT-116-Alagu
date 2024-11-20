package homework.M303_2;

import java.util.Arrays;

public class Glab303_3_1 {
    public static void main(String[] args) {
        String str1 = "Java";
        String str2 = "";
        String str3 = " ";

        System.out.println(str1.length());  // 4
        System.out.println(str2.length());  // 0
        System.out.println(str3.length());//1
        System.out.println("Java"+"Java".length());  // 4
        System.out.println("Java\n"+"Java\n".length()); // 5
        System.out.println("Learn Java"+"Learn Java".length()); // 10
        System.out.println("==============================================================");
        //===============================================================================
        String s1="";
        String s2="hello";
        System.out.println(s1.isEmpty());      // true
        System.out.println(s2.isEmpty());      // false
        System.out.println(str2.isEmpty());// true
        System.out.println(str3.isEmpty());
        System.out.println("==============================================================");
        //=================================================================================
        String s3 = "    Hello   ";
        System.out.println(s3+ "How are you");
        System.out.println(s3.trim()+ "How are you");
        System.out.println("==============================================================");
        //=================================================================================
        String s4 = "HELLO HOW are you?";
        String s4lowercase= s4.toLowerCase();
        System.out.println(s4);
        System.out.println(s4lowercase);
        System.out.println("==============================================================");
        //=================================================================================
        String s5 = "Hello World";
        String s5uppercase= s5.toUpperCase();
        System.out.println(s5);
        System.out.println(s5uppercase);
        System.out.println("==============================================================");
        //====================================================================================
        String s6 = "Learn";
        String s7 = "Java";
        System.out.println(s6.concat(s7));
        System.out.println(s7.concat(s6));
        String s8 = s6+s7;
        System.out.println(s8);
        String message = "Welcome" + "to"+"Java";
        System.out.println(message);
        String s9 = "Chapter"+ 2;
        System.out.println(s9);
        String s10 = "Supplement"+'B';
        System.out.println(s10);
        System.out.println("==============================================================");
        //======================================================================================
        String vowels = "a:e:i:o:u";
        System.out.println(vowels);
        String [] result = vowels.split(":");
        System.out.println("result ="+ Arrays.toString(result));
        System.out.println("==============================================================");
        //======================================================================================
        String s11= "Welcome to Java";
        System.out.println("The first and fifth letter of the message is "+ s11.charAt(0)+" and "+s11.charAt(4));
        System.out.println("==============================================================");
        //=======================================================================================
        String s12="hello";
        String s13="Hello";
        String s14="hemlo";
        String s15="flag";
        System.out.println(s12.compareTo(s13));
        System.out.println(s12.compareTo(s14));
        System.out.println(s12.compareTo(s15));
        System.out.println("==============================================================");
        //========================================================================================
        String s16="Java is fun";
        System.out.println(s16.substring(0,4));
        System.out.println("==============================================================");
        //========================================================================================
        int result1;
        result1= s16.indexOf("s");
        System.out.println("The index of s is "+result1);
        result1= s16.indexOf('J');
        System.out.println("The index of J is "+result1);
        result1= s16.lastIndexOf("a");
        System.out.println("The last index of a is "+result1);
        result1= s16.lastIndexOf("j");
        System.out.println("The last index of j is "+result1);
        result1= s16.lastIndexOf("ava");
        System.out.println("The last index of \"ava\" is "+result1);
        result1= s16.lastIndexOf("java");
        System.out.println("The last index of \"java\" is "+result1);
        System.out.println("==============================================================");
        //========================================================================================
        String s17="Learn Java";
        Boolean result2;
        result2= s17.contains("Java");
        System.out.println(result2);
        result2= s17.contains("Python");
        System.out.println(result2);
        result2= s17.contains(" ");
        System.out.println(result2);
        System.out.println("==============================================================");
        //========================================================================================
        String s18="abc cba";
        System.out.println(s18.replace('a','z'));
        System.out.println("Lava".replace('L','J'));
        System.out.println("Hello".replace('4','j'));
        System.out.println(s18.replace("C++","Java"));
        System.out.println("aa bb cc zz".replace('a','z'));
        System.out.println("Java".replace("C++","C"));
        System.out.println("==============================================================");
        //==========================================================================================
        String s19="Java123is456fun";
        String regex="\\d+";
        System.out.println(s19.replaceAll(regex," "));
        System.out.println("==============================================================");
        //==========================================================================================
        String s20="PerScholas";
        String s21="PerScholas";
        String s22=new String("PerScholas");
        String s23= "Teksystem";
        System.out.println(s20.equals(s21));
        System.out.println(s20.equals(s22));
        System.out.println(s20.equals(s23));
        System.out.println(s20==s21);
        System.out.println(s20==s22);
        System.out.println(s20.compareTo(s21));
        System.out.println(s20.compareTo(s22));
        System.out.println(s20.compareTo(s23));
        System.out.println("==============================================================");
        //============================================================================================








    }
}
