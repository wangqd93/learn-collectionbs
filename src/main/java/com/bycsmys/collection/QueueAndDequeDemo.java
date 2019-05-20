package com.bycsmys.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueAndDequeDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("hello");
        queue.offer("world");

    }
}
