package com.bycsmys.clone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeepCloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<String> values = new ArrayList<>();

        values.add("hello");
        values.add("welcome");

        //shallow copy
        List<String> shallowCopy = (List<String>) values.clone();

        displayDiff(values, shallowCopy);

        System.out.println("==================");

        List<String> deepClone = deepClone(values);
        displayDiff(values, deepClone);


        System.out.println("===============");

        List<String> seriliableClone = deepCloneBySerialization(values);
        displayDiff(values, seriliableClone);


    }


    /**
     * 深度copy
     *
     * @param source
     * @return
     */
    private static List<String> deepClone(List<String> source) {
        List<String> clone = new ArrayList<>(source.size());

        for (String value : source) {
            clone.add(new String(value));
        }
        return clone;
    }

    /**
     * 序列化deep copy
     *
     * @param source
     * @return
     */
    private static List<String> deepCloneBySerialization(List<String> source) throws IOException, ClassNotFoundException {
        ArrayList<String> copy = new ArrayList<>(source);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(copy);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        List<String> clone = (List<String>) objectInputStream.readObject();
        return clone;


    }

    /**
     * 对比
     *
     * @param values
     * @param clone
     */
    private static void displayDiff(List<String> values, List<String> clone) {
        for (int i = 0; i < values.size(); i++) {
            System.out.println(Objects.equals(values.get(i), clone.get(i)));
            System.out.println(values.get(i) == clone.get(i));
        }

    }


}
