package com.fyang.javaReflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class example01 {
    protected List<String> stringList = new ArrayList<String>();

    public void setStringList(List<String> list){
        this.stringList = list;
    }
}
