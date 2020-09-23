package com.fyang.javaSync;

public class Product implements Runnable{

    private Food food;

    public Product(Food food) {
        this.food = food;
    }

    public void run() {
        try {
            while (true){
                Thread.sleep(100);
                food.product();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
