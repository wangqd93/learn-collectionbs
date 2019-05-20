package com.bycsmys.collection;

import java.lang.ref.WeakReference;

public class WeakHashMapDemo {

    public static void main(String[] args) {


        demoWeakHashMap();
    }

    private static void demoWeakHashMap() {

        // 强引用
        // value 变量时局部变量，存放在栈
        // "abc" 是常量，在java 8 之前是放在perm 区域，java 8+ 是存放在META区域
        // 在 demoWeakHashMap() 方法执行结束后，value变量会被立即回收，"abc" 常量常驻
        String value = "abc";

        // 弱引用
        // WeakReference 继承Reference ，Reference 入队 ReferenceQueue
        User user = new User("bycsmys");
        WeakReference<User> userWeakReference = new WeakReference<>(user);

        //获取对象 对象被回收则返回null
        User userFromMap = userWeakReference.get();


    }


    private static class User{
        private String name ;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


