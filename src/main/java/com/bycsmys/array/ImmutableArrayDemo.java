package com.bycsmys.array;

import java.util.Arrays;

public class ImmutableArrayDemo {

    public static void main(String[] args) {
        User[] users = of(1L, 2L, 3L);

        User[] userCopy = Arrays.copyOf(users, users.length);

        User user = userCopy[0];
        user.setId(99L);

        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    private static User[] of(Long... values) {

        User[] users = new User[values.length];
        for (int i = 0; i < values.length; i++) {
            users[i] = new User(values[i]);
        }

        return users;
    }
}

class User {
    private long id;

    public User(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }
}
