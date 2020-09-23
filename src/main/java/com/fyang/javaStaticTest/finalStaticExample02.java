package com.fyang.javaStaticTest;

public class finalStaticExample02 {
    public static void main(String[] args) {
        System.out.println(AClass.A);
    }
}

class AClass {
    static final long A = System.currentTimeMillis();//在编译时无法确定

    static {
        System.out.println("静态块初始化");
    }
}
