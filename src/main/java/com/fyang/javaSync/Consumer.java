package com.fyang.javaSync;

public class Consumer implements Runnable{

    private Food food;

    public Consumer(Food food) {
        this.food = food;
    }

    public void run() {
        try {
            while (true){
                Thread.sleep(100);
                food.consumer();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
