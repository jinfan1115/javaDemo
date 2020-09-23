package com.fyang.threadPool;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

public class ScheduledPoolTest {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH.mm.ss");

    private static final Random random = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        scheduled();
//        scheduldeAtFixedRate();
//        scheduleWithFixedDelay();
        scheduledCallable();
    }

    // 特定时间延时后执行一次Runnable
    public static void scheduled(){
        ScheduledExecutorService scheduledExecutorService = getScheduledExecutorService();
        printTime();

        scheduledExecutorService.schedule(new Task(),3, TimeUnit.SECONDS);
    }

    // 特定时间延时后执行一次Callable
    public static Integer scheduledCallable() throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = getScheduledExecutorService();
        printTime();

        FutureTask<Integer>  futureTask = (FutureTask<Integer>) scheduledExecutorService.schedule(new ThreadPoolCallable(),3, TimeUnit.SECONDS);
        System.out.println("futureTask::"+futureTask.get());
        return null;
    }

    // 固定周期执行任务（与任务执行时间无关，周期是固定的）
    public static void scheduldeAtFixedRate(){
        ScheduledExecutorService scheduledExecutorService = getScheduledExecutorService();
        printTime();

        scheduledExecutorService.scheduleAtFixedRate(new Task(),2,10,TimeUnit.SECONDS);
    }

    // 固定延时执行任务（与任务执行时间有关，延时从上一次任务完成后开始）
    public static void scheduleWithFixedDelay(){
        ScheduledExecutorService scheduledExecutorService = getScheduledExecutorService();
        printTime();

        scheduledExecutorService.scheduleWithFixedDelay(new Task(),2,10,TimeUnit.SECONDS);
    }


    private static ScheduledExecutorService getScheduledExecutorService(){
        return Executors.newScheduledThreadPool(1);
    }

    static class Task implements Runnable{

        @Override
        public void run() {
            printTime();
            try {
                Thread.sleep(random.nextInt(5)*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void printTime() {
        Date date = new Date();
        System.out.println(simpleDateFormat.format(date));
    }
}
