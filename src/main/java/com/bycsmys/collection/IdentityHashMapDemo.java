package com.bycsmys.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {

    public static void main(String[] args) {

        demoHashMap();

        System.out.println("===========");

        demoIndentityHashMap();


    }

    private static void demoIndentityHashMap() {

        Map<String, Integer> map = new IdentityHashMap<>();
        map.put("A", 1);
        map.put(new String("A"), 1);


        System.out.println("A" == new String("A"));
        System.out.println("A".hashCode() == new String("A").hashCode());
        System.out.println("A".equals(new String("A")));

        System.out.println(map.size());   // 2

    }


    private static void demoHashMap() {
        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put(new String("A"), 1);


        System.out.println("A" == new String("A"));
        System.out.println("A".hashCode() == new String("A").hashCode());
        System.out.println("A".equals(new String("A")));

        //hashMap  是key 的 hashCode 和 equals 来实现
        System.out.println(map.size());   // 1

        // 如果类覆盖了Object 的 equals 方法，那么 hashCode() 方法需不需要覆盖？
        // 不强制，建议实现
        // 注意不要将hashCode()  作为equals 方法的实现，可参考Objects.hash (Object ... ) 以及 Arrays.hashCode(Object[]),
        // hashCode 是一个计算较重的实现， equals 通常是做对象属性的比较

        // 如果类覆盖了Object 的 hashCode方法，那么equals 方法需不需要覆盖？
        // hashCode() 是用于 hash计算，比如普通的HashMap，由于不同的对象的hashCode() 方法可能返回相同的数据
        // 原因一：int 数据范围 2^31 -1
        // 原因二：hashCode() 方法计算问题
        // 当不同的对象 hashCode() 相同时，再做对象 equals(Object) 方法比较
    }
}
