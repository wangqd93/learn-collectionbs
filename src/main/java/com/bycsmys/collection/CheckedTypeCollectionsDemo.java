package com.bycsmys.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckedTypeCollectionsDemo {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3));

        List copy = values;
        // 可以放入values 可以用checked* 集合检查就不会出现这种情况
        copy.add("A");

        System.out.println("=======================");

        List<Integer> checkedTypeValues = Collections.checkedList(values, Integer.class);
        checkedTypeValues.add(1);
        checkedTypeValues.add(2);
        checkedTypeValues.add(3);

        List copyChecked = checkedTypeValues;

        //Collections.checked* 接口是弥补泛型集合在运行时中的擦写中的漏洞
        //add 的时候会检查类型，即使擦除也不可以
        copyChecked.add("A");


    }
}
