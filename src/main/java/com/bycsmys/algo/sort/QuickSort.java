package com.bycsmys.algo.sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        int size = values.length;
        int low = 0;
        int high = size - 1;

        sort(values, low, high);

    }

    private void sort(T[] values, int low, int high) {
        if (low < high) {
            int pIndex = partition(values, low, high);

            sort(values, low, pIndex - 1);
            sort(values, low, pIndex + 1);
        }


    }

    private int partition(T[] values, int low, int high) {
        T pivot = values[high];

        int i = 0;

        for (int j = low; j < high; j++) {
            if (values[j].compareTo(pivot) > 0) {
                i++;
            }
        }

        for (int j = low; j < i; j++) {
            if (values[j].compareTo(values[i + j]) > 0) {
                T temp = values[j];
                values[j] = values[i + j];
                values[i + j] = temp;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        Integer[] values = {3,2,1,4,5};

        Sort<Integer> sort = new QuickSort<>();

        sort.sort(values);
        System.out.println(Arrays.toString(values));

    }
}
