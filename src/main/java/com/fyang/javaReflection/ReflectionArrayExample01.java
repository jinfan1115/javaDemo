package com.fyang.javaReflection;

import java.lang.reflect.Array;

public class ReflectionArrayExample01 {
    public static void main(String[] args) {
        int[] IntArray = (int[]) Array.newInstance(int.class,3);

        Array.set(IntArray,0,12);
        Array.set(IntArray,1,34);
        Array.set(IntArray,2,56);

        for (int a = 0;a<IntArray.length;a++) {
            System.out.println("IntArray index:" +a+";val = "+IntArray[a]);
        }
    }
}
