package com.bycsmys.algo.sort;

import java.util.Arrays;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        int n = values.length;
        int low = 0;
        int high = n - 1;

        sort(values, low, high);
    }

    private void sort(T[] values, int low, int high) {
        if (low < high) {

            int pIndex = partition(values, low, high);

            sort(values, low, pIndex - 1);
            sort(values, pIndex + 1, high);
        }
    }

    /**
     * 获取分区索引
     *
     * @param values 数组对象
     * @param low    低位索引
     * @param high   高位索引
     * @return 分区索引
     */
    int partition(T[] values, int low, int high) {
        T pivot = values[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (values[j].compareTo(pivot) < 1) { // <=
                T temp = values[i]; // 低位数据
                values[i] = values[j]; // 低位数据获取高位数据
                values[j] = temp;
                i++; // -1 -> 0
            }
        }

        T temp = values[i];
        values[i] = values[high];
        values[high] = temp;

        return i;
    }

    public static void main(String[] args) {
        Integer[] values = {2, 5, 6, 7, 8, 8, 9, 2, 1, 6, 7, 5, 6, 11, 23};
        Sort<Integer> sort = new QuickSort<>(); // Java 7 Diamond 语法
        sort.sort(values);
        System.out.println(Arrays.asList(values));
    }
}