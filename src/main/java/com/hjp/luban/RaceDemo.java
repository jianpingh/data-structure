package com.hjp.luban;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @auther huang jianping
 * @date 2019/4/29 12:15
 */
public class RaceDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(8);
        Thread[] play=new Thread[8];
        for (int i = 0; i < 8; i++) {

            play[i]=new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"准备好了");
                    try {
                        cyclicBarrier.await();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("选手"+Thread.currentThread().getName()+"开始起跑");
            },"play["+i+"]");
            play[i].start();
        }



    }
}
