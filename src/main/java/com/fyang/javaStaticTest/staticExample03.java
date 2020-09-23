package com.fyang.javaStaticTest;

public class staticExample03 {
    static int a = 5;    //初始化时赋值
    static int b;        //初始化时赋值--静态块
    static int c;        //连接时赋默认值值
    static{
        b = 6;
    }

    public static void main(String[] args) {
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);

    }
}

