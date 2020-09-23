package com.fyang.javaSync;

public class sycnTest {
    public static void main(String[] args) {
        Food food = new Food();
        Thread thread1 = new Thread(new Product(food),"线程一");
        Thread thread2 = new Thread(new Product(food),"线程二");

        Thread thread3 = new Thread(new Consumer(food),"线程三");
//        Thread thread4 = new Thread(new Consumer(food),"线程四");

        thread1.start();
        thread2.start();
        thread3.start();
//        thread4.start();

    }
}
