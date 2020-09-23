package com.fyang.threadPool;

import java.util.concurrent.*;

public class CallableThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        exexutorFunc();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(4,
                5,
                60,
                TimeUnit.SECONDS,
                new MyLinkedBlockingQueue<>(10),
                new NamedThreadFactory("threadPool demo"),
                new ThreadPoolExecutor.DiscardPolicy());
    }

    private static void exexutorFunc() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        int result = 0;
        for (int i = 0 ; i< 15; i++){
            Callable<Integer> callable = new ThreadPoolCallable();
            FutureTask<Integer> futureTask = new FutureTask<>(callable);

            executor.submit(futureTask);
            result += futureTask.get();
        }

        executor.shutdown();
        System.out.println("result = " + result);
    }
}
