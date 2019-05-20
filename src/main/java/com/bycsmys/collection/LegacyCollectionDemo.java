package com.bycsmys.collection;

import java.util.StringTokenizer;
import java.util.Vector;

public class LegacyCollectionDemo {

    public static void main(String[] args) {


        enumerationVsEnum();

    }


    /**
     * vector 数组实现，和arrayList实现类似
     *
     * 线程安全
     */
    public static void vectorVsList(){
        Vector<String> vector = new Vector<>();
    }

    /**
     * vector 是FIFO  stack是 LIFO
     *
     */
    public static void vectorVsStack(){

    }

    /**
     * hashtable 实现了Dictionary和map接口  HashMap实现了Map接口
     * hashtable 是线程安全的
     * hashtable value 不允许为null  hashMap没有限制  currentHashMap key/value 都不允许为空
     *
     *
     */
    public static void hashtableVsHashMap(){

    }

    /**
     * enumeration 是负责迭代的，由于是从java.util.Iterator 从1.2实现
     */
    public static void enumerationVsEnum(){
        String value = "1,2,3";
        StringTokenizer stringTokenizer = new StringTokenizer(value,",");

        while (stringTokenizer.hasMoreElements()){
            System.out.println(stringTokenizer.nextElement());
        }

    }

    /**
     * 线程非安全
     * 用于位运算集合操作，可以搭配 NIO ByteBuffer
     */
    private static void bitSet(){

    }
}
