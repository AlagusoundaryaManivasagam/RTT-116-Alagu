package M303_5;

public class SBAReview {
    public static void main(String[] args){
        String characters = "abcdefg";

        for (int pos = 0; pos < characters.length(); pos++) {
            System.out.println("Characters at position" + pos + " = " + characters.charAt(pos));
        }
        char one = '1';
        Character c = one;
        int x =Integer.parseInt(c.toString());
        System.out.println(x);
    }
}
