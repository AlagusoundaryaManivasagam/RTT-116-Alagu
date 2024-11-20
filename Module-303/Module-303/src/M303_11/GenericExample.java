package M303_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericExample {
    public static void main(){
        // type in <> is the only type allowed in list
        // in older version we should write type on both sides of array declaration
        //now we can write type pnly on left side
        List<String> strings = new ArrayList<>();
        strings.add("String1");
        List<Integer> ints = new ArrayList<>();
        ints.add(1);

        //This one is a map
        //Map<K,V>
        Map<String, Integer> n = new HashMap<>();
        n.put("one", 1);

    }
}
