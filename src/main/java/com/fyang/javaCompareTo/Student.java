package com.fyang.javaCompareTo;

public class Student implements Comparable<Student>{
    private  String name;
    private  int age;
    private  String id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }

        if(obj.getClass() != this.getClass()){
            return false;
        }

        Student student = (Student) obj;
        if(!student.getName().equals(getName())){
            return false;
        }
        return true;
    }


    public int compareTo(Student stu) {
        return this.age-stu.age;
    }
}
