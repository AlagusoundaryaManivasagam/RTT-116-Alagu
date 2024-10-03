package homework.M303_2;

public class AssignmentOperatorsDemo {
    public static void main(String[] args) {
        //   Assigning Primitive Values
        int j, k;
        j = 10;
        j =7; // value reassigned
        k = j;
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);

        //   Multiple Assignments
        k = j = 15;
        System.out.println("j is : " + j);
        System.out.println("k is : " + k);

    }
}
