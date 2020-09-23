package com.fyang.javaStaticTest;

public class staticExample01 {
    public static void main(String[] args) {
        Atest.a++;
        System.out.println(Atest.a);
    }

}

class Atest{
    public static int a = 1;
  }
