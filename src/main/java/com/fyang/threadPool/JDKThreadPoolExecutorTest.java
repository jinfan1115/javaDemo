package com.fyang.threadPool;

import java.util.concurrent.*;

public class JDKThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10));
        Future<String> future = executor.submit(() -> {
            System.out.println("开始执行!!!");
            return "返回结果";
        });

        System.out.println("future的内容：："+ future.get());
    }
}
