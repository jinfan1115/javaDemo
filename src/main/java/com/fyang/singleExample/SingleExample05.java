package com.fyang.singleExample;

public class SingleExample05 {

    private volatile static SingleExample05 singleIni = null;

    private SingleExample05(){}

    public static SingleExample05 getSingleIni(){
        if(singleIni == null){
            synchronized (SingleExample05.class){
                if(singleIni == null){
                    singleIni = new SingleExample05();
                }
            }
        }
        return singleIni;
    }
}
