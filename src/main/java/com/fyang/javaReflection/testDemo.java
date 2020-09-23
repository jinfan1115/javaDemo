package com.fyang.javaReflection;

import java.lang.reflect.Method;
import java.util.List;

public class testDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = example01.class.getMethod("setStringList",List.class);
        System.out.println(method.getName());
    }
}
