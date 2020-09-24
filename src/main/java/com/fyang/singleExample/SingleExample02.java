package com.fyang.singleExample;

public class SingleExample02 {

        private static SingleExample02 singleIni = new SingleExample02();

        private SingleExample02(){}

        public static SingleExample02 getSingleIni(){
            return singleIni;
        }
}
