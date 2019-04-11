package com.hjp.volatiletest;


public class Task implements Runnable{

    boolean running=true;
    int i=0;

    public  void run(){
        while (running){
            i++;
            //System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        Task task=new Task();
        Thread th =new Thread(task);
        th.start();
        Thread.sleep(10);
        task.running=false;
        Thread.sleep(100);
        System.out.println(task.i);
        System.out.println("程序停止");


    }
}
