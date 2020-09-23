package com.fyang.javaStaticTest;

public class finalStaticExample01 {
    public static void main(String[] args) {
        System.out.println(aClass.A);
    }
}
class aClass {
    static final int A = 111;//可以确定

    static {
        System.out.println("静态块初始化");
    }
}
