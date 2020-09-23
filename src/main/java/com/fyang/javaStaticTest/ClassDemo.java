package com.fyang.javaStaticTest;

public class ClassDemo {
    public static void main(String[] args) {
        staticFunction();
    }
    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量

    static {   //静态代码块
        System.out.println("1");
    }

    ClassDemo() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    {       // 实例代码块
        System.out.println("2");
        System.out.println(a);
    }

    static ClassDemo st = new ClassDemo();

    public static void staticFunction() {   // 静态方法

        System.out.println("4");
    }

}
