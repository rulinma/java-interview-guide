package com.rulinma.interview;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {

    public static void main(String[] args) {
//        test();
        User obj = new User();
        obj.setName("test");

        SoftReference<User> softReference = new SoftReference<>(obj);

        System.out.println(obj);
        System.out.println(softReference.get());
        obj = null;
        System.gc();

        System.out.println(obj);
        System.out.println(softReference.get());
    }

    private static void test() {
        Object obj = new Object();

        SoftReference<Object> softReference = new SoftReference<>(obj);

        System.out.println(obj);
        System.out.println(softReference.get());
        obj = null;
        System.gc();

        System.out.println(softReference.get());
    }

}

class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
