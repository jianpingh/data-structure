package com.hjp.luban;

/**
 * @auther huang jianping
 * @date 2019/4/29 09:23
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("子线程ID："+Thread.currentThread().getId());
        MyRunnable myRunnable=new MyRunnable();
        Thread thread=new Thread(myRunnable);
        thread.start();

        //lamda
        new Thread(()->{
            System.out.println("B子线程ID："+Thread.currentThread().getId());
        },"test").start();



    }
}


class MyRunnable implements Runnable{

    @Override
    public void run() {

        System.out.println("A子线程ID："+Thread.currentThread().getId());

    }
}
