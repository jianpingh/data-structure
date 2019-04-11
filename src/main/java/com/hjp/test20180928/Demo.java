package com.hjp.test20180928;

public class Demo implements Runnable {

    private ChangeInfo changeInfo;
    final ThreadLocal<ChangeInfo> local = new ThreadLocal<ChangeInfo>();

    //通过构造方法把对象传过来
    public Demo(ChangeInfo changeInfo) {
        this.changeInfo = changeInfo;
    }

    @Override
    public void run() {
        //先把对象引用放到ThreadLocal中保存
        local.set(changeInfo);
        //输出本线程中对象name属性
        System.out.println(Thread.currentThread().getName() + "该线程设置值之前>>>" + local.get().getName() + "|||||||||" + changeInfo);
        //更改本线程对象的Name属性
        local.get().setName("aaaaaaaaaa");
        System.out.println(Thread.currentThread().getName() + "该线程设置值之后来+++>>>" + local.get().getName() + "|||||||||" + changeInfo);
    }
}
