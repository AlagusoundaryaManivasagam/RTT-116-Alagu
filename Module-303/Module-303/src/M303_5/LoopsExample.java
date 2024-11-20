package M303_5;

import java.util.ArrayList;
import java.util.List;

public class LoopsExample {
    public static void main(String[] args) {
        for (int count = 1; count <= 10; count++) {
            System.out.println("For loop interation " + count);
        }
        for (int count = 10; count >= 1; count--) {
            System.out.println("For loop interation " + count);
        }
        String[] strings = {"one", "two", "three", "four", "five"};
        //old style loop

        for (int pos = 0; pos < strings.length; pos++) {
            System.out.println("Strings at position" + pos + " = " + strings[pos]);
        }
        //new loop
        //in new loop we dont have count so we should explicitly declare a counter and increment it in
        for(String string: strings) {
            System.out.println("New loop  " + string);
        }
        String characters = "abcdefg";

        for (int pos = 0; pos < characters.length(); pos++) {
            System.out.println("Characters at position" + pos + " = " + characters.charAt(pos));
        }
        for(char ch: characters.toCharArray()) {
            System.out.println("New loop for char " + ch);
        }
        //looping over a list
        List<String> stringlist = new ArrayList<String>();
        stringlist.add("One");
        stringlist.add("Two");
        stringlist.add("Three");
        stringlist.add("Four");
        stringlist.add("Five");
        for(int pos = 0; pos < stringlist.size(); pos++) {
            System.out.println("string at list position" + pos + " = " + stringlist.get(pos));
        }
        //new style loop
        //easier to type and read but does not contain position in the list that each item come from
        for(String string : stringlist) {
            System.out.println("New for loop "+ string);
        }

    }
}
