package com.bycsmys.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "A");

        System.out.println(map.get(1));
        System.out.println(map.get(1L));
        System.out.println(map.get(1.0));
        System.out.println(map.get(new Key(1)));
    }

    private static class Key {
        private int value;

        public Key(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            int i = (int) o;
            return i == value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}
