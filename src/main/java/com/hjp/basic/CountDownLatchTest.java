package com.hjp.basic;

import java.util.concurrent.CountDownLatch;

/**
 * @auther huang jianping
 * @date 2019/4/20 15:05
 */
public class CountDownLatchTest {

    public static void main( String[] args ) {
        System.out.println("主线程和他的两个小兄弟约好去吃火锅");
        System.out.println("主线程进入了饭店");
        System.out.println("主线程想要开始动筷子吃饭");
        //new一个计数器，初始值为2，当计数器为0时，主线程开始执行
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程1——小兄弟A 正在到饭店的路上");
                    Thread.sleep(6000);
                    System.out.println("子线程1——小兄弟A 到饭店了");
                    //一个小兄弟到了，计数器-1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程2——小兄弟B 正在到饭店的路上");
                    Thread.sleep(3000);
                    System.out.println("子线程2——小兄弟B 到饭店了");
                    //另一个小兄弟到了，计数器-1
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();

        //主线程等待，直到其他两个小兄弟也进入饭店（计数器==0），主线程才能吃饭
        try {
            System.out.println("主线程还在焦急的等待中～");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程终于可以开始吃饭了～");
    }

}
