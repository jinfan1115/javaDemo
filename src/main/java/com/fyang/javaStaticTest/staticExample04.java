package com.fyang.javaStaticTest;

public class staticExample04 {
    static String classPath = "Tester";

    public static void main(String[] args) throws ClassNotFoundException, Exception, IllegalAccessException {
//        ClassLoader cl = ClassLoader.getSystemClassLoader();
//        Class<?> a = cl.loadClass(classPath); // 用到了 Tester类 加载一个类，并不会导致一个类的 初始化
//
//        // 调用newInstance()方法
//        a.newInstance(); // 输出：____________静态块加载
//        // 使用Class.forName方法
//        Class.forName(classPath); // 输出：____________静态块加载
//        // 调用类变量
//        int value = Tester.value;
//        Tester.name = "jason"; // 输出：____________静态块加载
//        // 调用类方法
//        Tester.method(); // 输出：____________静态块加载   一个类方法
        // new 实例化
        Tester t = new Tester(); // 输出：____________静态块加载
    }
}

class Tester {
    public static int value = 10;
    public static String name;

    public static void method() {
        System.out.println("一个类方法");
    }

    static {
        System.out.println("Tester的类的静态初始化。。。");
    }

    {       // 实例代码块
        System.out.println(value);
        System.out.println("2");
    }
}

