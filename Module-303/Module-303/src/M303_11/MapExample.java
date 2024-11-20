package M303_11;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String [] args){
        Map<String,Integer> numbers = new HashMap<>();
        numbers.put("one",1);
        numbers.put("two", 2);
        numbers.put("ten",10);
        numbers.put("ten",100);// it overrides original value 10
        numbers.put("five",1);// value can be duplicate, but key cannot be
        // we can retrieve thoimgs from map using the key

        numbers.put(null,1000);//value when there is no key
        numbers.put("one", null);//this sets value 0
        Integer notFound = numbers.get("thousand");
        System.out.println("not found ="+notFound);

        //removing a key and value
        numbers.remove("ten");// only key is needed to remove the key value pair

        Integer x= numbers.get("one");
        Integer x2 = numbers.get("five");
        Integer x3 = numbers.get("ten");
        Integer x4 = numbers.get("three");
        System.out.println("x ="+ x);
        System.out.println("x2 ="+ x2);
        System.out.println("x3 ="+ x3);
        System.out.println("x4 ="+ x4);

        // we can loop over hashmap similar to how we could loop over a list
        // first we need to get all keys in the map
        // the method to get set of keys from the maps is called keySet();
        // we do not know order the keyset will return in not guaranteed
        // this is what is used a lot
        for(String key: numbers.keySet()){
            Integer value = numbers.get(key);
            System.out.println(key+ " = "+ value);
        }
        //we also can loop over values in hashmap
        // this is not used frequently
        for(Integer i: numbers.values()){
            // we dont know which value belongs to which key
            //order is random
            System.out.println(i);
        }
    }
}
