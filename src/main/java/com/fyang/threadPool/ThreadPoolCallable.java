package com.fyang.threadPool;

import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        int number = random.nextInt(10);

        System.out.println(Thread.currentThread().getName() + "--" + number);
        return number;
    }
}
