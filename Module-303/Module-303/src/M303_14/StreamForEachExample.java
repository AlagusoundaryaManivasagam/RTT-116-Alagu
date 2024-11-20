package M303_14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamForEachExample {
    public static void main(String [] args){
        String [] strArray = {"one", "two", "three", "four", "five"};
        List<String > list = Arrays.asList(strArray);

        //this is lambda expression
        list.stream().forEach(e->{
            System.out.println(e.toUpperCase());
            //many lines of code can be in there
        });
        System.out.println("=========================================");
        // this is how we would see the lambda expression often
        list.stream().forEach(e-> System.out.println(e.toUpperCase()));
        System.out.println("=============================================");
        list.forEach(e-> System.out.println(e.toUpperCase()));
        System.out.println("================================================");


        // this is to find a list of things in a list which matches a criteria
        //stream doesnot affect the original list
        List<String> filteredList = list.stream().filter(e->e.startsWith("o")).
                collect(Collectors.toList());
        filteredList.stream().forEach(e-> System.out.println(e));
        System.out.println("==================================================");

        List<String> filteredList2 = list.stream().filter(e->!e.startsWith("o")).
                collect(Collectors.toList());

        filteredList2.stream().forEach(e-> System.out.println(e));
        System.out.println("==================================================");


        //Instead of using collectors we can just use toList()
        List<String> filteredList1 = list.stream().filter(e->!e.startsWith("o")).
                filter(e-> e.startsWith("t")).toList();
        filteredList1.stream().forEach(e-> System.out.println(e));
        System.out.println("==================================================");


        // removeif is not working becase we didn't create the array list with a new keyword
        list.removeIf(e-> e.startsWith("o"));
        list.stream().forEach(e-> System.out.println(e));
    }
}
