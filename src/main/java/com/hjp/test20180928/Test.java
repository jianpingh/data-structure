package com.hjp.test20180928;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ChangeInfo ChangeInfo=new ChangeInfo("KKKKK");
        Demo d=new Demo(ChangeInfo);
        Thread t1=new Thread(d);
        Thread t2=new Thread(d);
        Thread t3=new Thread(d);
        Thread t4=new Thread(d);
        Thread t5=new Thread(d);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }

}

