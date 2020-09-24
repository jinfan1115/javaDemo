package com.fyang.singleExample;

public class SingleExample04 {

    private static class SingleExampleHandler {
        static SingleExample04 getsingleExample04 = new SingleExample04();
    }

    private SingleExample04(){}

    public static synchronized SingleExample04 getSingleIni(){
        return SingleExampleHandler.getsingleExample04;
    }
}
