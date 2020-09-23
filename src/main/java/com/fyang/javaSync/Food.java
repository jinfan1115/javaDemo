package com.fyang.javaSync;


public class Food {
    private static int num = 0;

    public synchronized void product() {
        try {
            if(num< 10){
                num ++;
                System.out.println(Thread.currentThread().getName() +"真正写入数据" + num);
            }else{
                System.out.println( "仓库已满，等待消费");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void  consumer(){
        try {
            if(num> 5){
                num --;
                System.out.println(Thread.currentThread().getName() + "消费一个食物，----仓库剩余"+num);
            }else{
                System.out.println( "等待生产");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
