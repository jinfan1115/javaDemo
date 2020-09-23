package com.fyang.demo;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        List<Object> list= new ArrayList<>();
        list.add(1);
        list.add("asfd");

        for (int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
