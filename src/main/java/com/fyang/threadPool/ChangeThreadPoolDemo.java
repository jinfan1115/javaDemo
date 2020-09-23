package com.fyang.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ChangeThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        dynamicModifyExecutor();
    }

    private static ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                    5,
                    60,
                    TimeUnit.SECONDS,
                    new MyLinkedBlockingQueue<>(10),
                    new NamedThreadFactory("threadPool demo"),
                    new ThreadPoolExecutor.DiscardPolicy());
    }

    private static void dynamicModifyExecutor() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = buildThreadPoolExecutor();
        for (int i =0 ; i < 20; i++){
            threadPoolExecutor.submit(() -> {threadPoolStstus(threadPoolExecutor,"创建任务");});
//            try {
//                TimeUnit.SECONDS.sleep(5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        threadPoolStstus(threadPoolExecutor,"改变之前");
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaximumPoolSize(10);
        threadPoolExecutor.prestartCoreThread();
        MyLinkedBlockingQueue queue = (MyLinkedBlockingQueue) threadPoolExecutor.getQueue();
        queue.setCapacity(20);
        threadPoolStstus(threadPoolExecutor,"变更之后");
        Thread.currentThread().join();
    }

    private static void threadPoolStstus(ThreadPoolExecutor threadPoolExecutor, String name) {
        MyLinkedBlockingQueue queue = (MyLinkedBlockingQueue) threadPoolExecutor.getQueue();
        System.out.println(Thread.currentThread().getName()+"--"+name + "--" +
                ";核心线程数："+ threadPoolExecutor.getCorePoolSize() +
                ";最大线程数:" + threadPoolExecutor.getMaximumPoolSize() +
                ";活跃线程数:" + threadPoolExecutor.getActiveCount()+
                ";任务完成数:" + threadPoolExecutor.getCompletedTaskCount() +
                ";队列大小:" + (queue.size() + queue.remainingCapacity()) +
                ";当前排队线程数:" + queue.size() +
                ";队列剩余大小：" + queue.remainingCapacity());
    }
}
