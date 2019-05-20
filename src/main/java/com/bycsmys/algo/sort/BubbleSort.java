package com.bycsmys.algo.sort;


import java.util.Arrays;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        int size = values.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (values[i].compareTo(values[j]) > 0) {
                    T temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = {3,2,1,5,4};

        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        System.out.println(Arrays.toString(values));
    }
}
