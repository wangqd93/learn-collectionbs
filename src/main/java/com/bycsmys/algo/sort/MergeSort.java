package com.bycsmys.algo.sort;

import java.util.stream.Stream;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {


    @Override
    public void sort(T[] values) {
        sort(values, 0, values.length - 1);
    }

    private void merge(Comparable[] values, int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;
        // 非 In-Place 实现(创建新的数组)
        Comparable[] a1 = new Comparable[n1];
        Comparable[] a2 = new Comparable[n2];

        //把 values[0...mid] 内容复制给 a1
        System.arraycopy(values, low, a1, 0, n1);
        //把 values[mid+1...high] 内容复制给 a2
        System.arraycopy(values, mid + 1, a2, 0, n2);



        int k = low; // k 临时保存低位索引
        int i = 0, j = 0;
        for (; i < n1 && j < n2; k++){
            // 如果 a1 与 a2 比较
            if (a1[i].compareTo(a2[j]) < 1) {  // <=
                values[k] = a1[i]; // 低位数值
                i++;
            } else { // >
                values[k] = a2[j];
                j++;
            }
        }


        // 复制 a1 剩余元素
        while (i < n1) {
            values[k] = a1[i];
            i++;
            k++;
        }

        // 复制 a2 剩余元素
        while (j < n2) {
            values[k] = a2[j];
            j++;
            k++;
        }
    }

    private void sort(T[] values, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            // Divide
            // 上半部分
            sort(values, low, mid);
            // 下半部分
            sort(values, mid + 1, high);
            // Conquer
            merge(values, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Integer[] values = {3, 1, 2, 5, 4};
        Sort<Integer> sort = new MergeSort<>(); // Java 7 Diamond 语法
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
