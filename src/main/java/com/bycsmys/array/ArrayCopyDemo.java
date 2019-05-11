package com.bycsmys.array;

import java.util.Arrays;

/**
 * array copy
 */
public class ArrayCopyDemo {

    public static void main(String[] args) {

        String[] source1 = new String[]{"hello", "world"};
        String[] target1 = new String[source1.length];

        System.arraycopy(source1, 0, target1, 0, source1.length);

        System.out.println(Arrays.toString(source1));
        System.out.println(Arrays.toString(target1));


        String[][] source2 = new String[][]{{"hello", "world"}, {"hello", "welcome"}, {"world", "welcome"}};
        String[][] target2 = new String[source2.length][source2[0].length];

        /**
         * public static native void arraycopy(Object src,  int  srcPos,Object dest, int destPos,int length);
         * 其中src和dest 都为object 的理由为 可以copy 多维数组
         */
        System.arraycopy(source2, 0, target2, 0, source2.length);

        /**
         * Arrays.deepToString 打印多维数组
         */
        System.out.println(Arrays.deepToString(source2));
        System.out.println(Arrays.deepToString(target2));


        /**
         * 自己实现打印多维数组
         */
        Integer[][] integerArrays = new Integer[][]{{1,2},{3}};
        printArray(integerArrays);

        String[][] stringArrays = new String[][]{{"hello","world"},{"welcome"}};
        printArray(stringArrays);
    }

    /**
     * 自己实现打印多维数组
     *
     * @param array
     */
    private static void printArray(Object[] array) {
        StringBuilder builder = new StringBuilder();
        if (array == null) {
            builder.append("null");
            return;
        }

        append(builder, array);
        builder.append("]");

        System.out.println(builder.toString());

    }

    /**
     * 递归拼接数组
     * @param builder
     * @param array
     */
    private static void append(StringBuilder builder, Object[] array) {
        builder.append("[");
        for (int i = 0; i < array.length; i++) {
            Object element = array[i];
            Class clazz = element.getClass();
            if (clazz.isArray()) {
                append(builder, (Object[]) array[i]);
            } else {
                builder.append(element.toString()).append(",");
            }
        }

        builder.delete(builder.length() - 1, builder.length());
        builder.append("]");
    }

}
