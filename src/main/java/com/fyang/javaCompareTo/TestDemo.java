package com.fyang.javaCompareTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("aaaaaaa",24,"1"));
        list.add(new Student("bbbbbbb",25,"2"));
        list.add(new Student("ccccccc",26,"3"));

        Collections.sort(list);

        Student stu = new Student("bbbbbbb",26,"2");

        //实现机制是equals
        int index1 = list.indexOf(stu);
        //实现机制是compareTo,
        int index2 = Collections.binarySearch(list,stu);

        System.out.println("index1::"+index1);
        System.out.println("index2::"+index2);
    }
}
