package com.bycsmys.algo.sort;

import java.util.Arrays;

public class InsertSort<T extends Comparable> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        for (int i = 1; i < values.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (values[j - 1].compareTo(values[j]) > 0) {
                    T temp = values[j - 1];
                    values[j - 1] = values[j];
                    values[j] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        Integer[] values = {3, 2, 1, 5, 4};

        Sort<Integer> sort = new InsertSort<>();
        sort.sort(values);
        System.out.println(Arrays.toString(values));
    }
}
