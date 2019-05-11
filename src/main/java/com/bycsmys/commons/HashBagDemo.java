package com.bycsmys.commons;

import org.apache.commons.collections.bag.HashBag;

import java.util.Collection;

/**
 * HashBag 用hashMap存储 提供根据key获取次数
 */
public class HashBagDemo {


    public static void main(String[] args) {
        HashBag bag = new HashBag();
        initColletions(bag);


        System.out.println(bag.getCount("welcome"));


    }

    private static void initColletions( Collection collection) {
        collection.add("hello");

        collection.add("world");
        collection.add("world");


        collection.add("welcome");
        collection.add("welcome");
        collection.add("welcome");
    }


}
