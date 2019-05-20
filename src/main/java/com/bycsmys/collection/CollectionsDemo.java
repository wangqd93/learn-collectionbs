package com.bycsmys.collection;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

    public static void main(String[] args) {

        singletonListDemo();

        singletonSetDemo();

        singletonMapDemo();

    }

    public static void singletonListDemo() {
        List<String> list = Collections.singletonList("hello");

//        singletonList.add("world");     new UnsupportedOperationException()

        list.forEach(System.out::println);
    }

    public static void singletonSetDemo() {
        Set<String> set = Collections.singleton("hello");

//        set.add("hello");    new UnsupportedOperationException()

        set.forEach(System.out::println);
    }

    public static void singletonMapDemo() {
        Map<String, String> map = Collections.singletonMap("hello", "world");

        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
