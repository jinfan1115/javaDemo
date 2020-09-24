package com.fyang.singleExample;

public class SingleExample01 {

        private static SingleExample01 singleIni = null;

        private SingleExample01(){}

        public static SingleExample01 getSingleIni(){
            if(singleIni == null){
                singleIni = new SingleExample01();
            }
            return singleIni;
        }
}
