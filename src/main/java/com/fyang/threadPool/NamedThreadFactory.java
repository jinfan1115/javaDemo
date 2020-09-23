package com.fyang.threadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class NamedThreadFactory implements ThreadFactory {

    private int counter;
    private String name;
    public NamedThreadFactory(String str) {
        this.name = str;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,name +"--"+counter);
        counter ++ ;
        return t;
    }
}
