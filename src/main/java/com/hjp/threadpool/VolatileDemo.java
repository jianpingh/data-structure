package com.hjp.threadpool;

/**
 * 腾讯课堂搜索 咕泡学院
 * 加群获取视频：608583947
 * 风骚的Michael 老师
 */
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
