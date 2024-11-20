package Hackerrank44;

import java.util.ArrayList;
import java.util.List;

public class Sublist {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<List<Integer>> sublists = getAllSublists(list);

        System.out.println("All sublists:");
        for (List<Integer> sublist : sublists) {
            System.out.println(sublist);
        }
    }

    public static <T> List<List<T>> getAllSublists(List<T> list) {
        List<List<T>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j <= list.size(); j++) {
                result.add(list.subList(i, j));
            }
        }

        return result;
    }
}
