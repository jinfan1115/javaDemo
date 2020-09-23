package com.fyang.threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadException {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = buildThreadPoolExecutor();
        executor.execute(() -> sayii("executor_1"));
        executor.execute(() -> sayii("executor_2"));
        executor.execute(() -> sayii("executor_error"));
        executor.execute(() -> sayii("executor_3"));
        executor.execute(() -> sayii("executor_4"));

//        TimeUnit.MILLISECONDS.sleep(10);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        Future<?> future =  executor.submit(() -> sayii("submit"));
//        try {
//            future.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        executor.shutdown();

    }
    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(5,
                10,
                60,
                TimeUnit.SECONDS,
                new MyLinkedBlockingQueue<>(15),
                new NamedThreadFactory("threadPool demo"),
                new ThreadPoolExecutor.CallerRunsPolicy());
    }

    private static void sayii(String name){
        String printStr = "threadname::"+ Thread.currentThread().getName()+"；；执行方式：："+name;

        System.out.println(printStr);
        if("executor_error".equals(name)){
            throw new RuntimeException(printStr+";异常出错");
        }
    }
}
