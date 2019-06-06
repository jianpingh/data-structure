package com.hjp.threadpool;

public class VolatileDemo {

    public static boolean stop=false; //多了一个lock指令->  lock汇编指令

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            int i=0;
            while(!stop){
                i++;
            }
        }).start();

        Thread.sleep(1000);
        stop=true;
    }
}
