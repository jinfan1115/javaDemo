package com.fyang.singleExample;

public class SingleExample03 {

    private static SingleExample03 singleIni = null;

    private SingleExample03(){}

    public static synchronized SingleExample03 getSingleIni(){
        if(singleIni == null){
            singleIni = new SingleExample03();
        }
        return singleIni;
    }
}
