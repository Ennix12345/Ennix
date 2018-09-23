package uz.ennix;

import java.util.*;
import java.util.stream.Stream;

public class Mine {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Iphone", 1000);
        map.put("Nokia", 700);
        map.put("Moto", 920);
        map.put("Xenovo", 920);
        map.put("Samsung", 1500);

        System.out.println(map);
        Stream<Map.Entry<String, Integer>> st = map.entrySet().stream();
        st.sorted(Map.Entry.comparingByValue()).
                forEach(System.out::println);

        NavigableSet link = new TreeSet();
        link.add("a");
        link.add("b");
        link.add("c");
        link.add("d");
        link.add("e");

        Object subset = link.pollLast();
        System.out.println(subset);
    }
}







