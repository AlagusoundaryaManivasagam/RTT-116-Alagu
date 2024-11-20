package M303_11;

import java.util.*;

public class ListSetExample {
    public static void main(String[] args){
        List<Object> objects = new ArrayList<>();
        objects. add("String");
        objects.add(1);

        // order and duplicate
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(3);
        for(Integer i:intList){
            System.out.println(i);
        }
        System.out.println("========================================");
        //we need to get iterator from list
        Iterator<Integer> iterator = intList.iterator();
        //loop over the list using an iterator, we check to make sure the iterator  has a next element
        while (iterator.hasNext()){
            // next function has two function , return element move pointer over one element
            Integer i = iterator.next();

            //primary use for an iterator is when you want to remove something from the list while iterating
            // the list
            if(i==3){
                //in normal for loop you can never remove an element from the list
                // it will cause an exception
                iterator.remove();
            }
        }
        System.out.println("=====================================================");
        for(Integer i:intList){
            System.out.println(i);
        }
        System.out.println("=====================================");
        // no order no duplicate
        // it may look like the result is sorted or there is some order, but its a coincidence
        // The result is not ordered
        Set<String > intSet = new HashSet<>();
        intSet.add("one");
        intSet.add("three");
        intSet.add("two");
        intSet.add("three");
        for (String i: intSet){
            System.out.println(i);
        }
        System.out.println("======================================");
        /*for (String i: intSet){
            System.out.println(i);
        }
        System.out.println("======================================");
        for (String i: intSet){
            System.out.println(i);
        }
        System.out.println("======================================");
        for (String i: intSet){
            System.out.println(i);
        }
        System.out.println("======================================");
        for (String i: intSet){
            System.out.println(i);
        }
        System.out.println("=======================================");*/


    }
}
