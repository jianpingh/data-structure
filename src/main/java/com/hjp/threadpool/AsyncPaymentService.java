package com.hjp.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 异步处理的方式提升支付的处理性能
 */
public class AsyncPaymentService {
    //要用到多线程

    //构建阻塞队列
    LinkedBlockingQueue<PaymentRequest> taskQueues=new LinkedBlockingQueue<>();

    //线程池（如果不理解，稍后我会详细讲解）
    final ExecutorService single=Executors.newFixedThreadPool(2);

    ThirdPaymentService paymentService=new ThirdPaymentService();

    public static volatile boolean isRunning=true; //控制属性 ; volatile实现可见性

    {
        init();//初始化异步处理机
    }

    public String submitPay(PaymentRequest request){
        // 实名认证的判断
        // 绑卡的判断
        // 账户安全的判断(风控）
        System.out.println("开始处理支付请求："+request);
        taskQueues.add(request);
        return "PROCESSING"; //支付处理中
    }

    //从队列中获取请求，进行处理.(构建一个异步处理过程）
    public void init(){
        single.execute(new Runnable() {
            @Override
            public void run() {
                while(isRunning){
                    try {
                        PaymentRequest request=taskQueues.take();//阻塞获取队列中的请求数据
                        String resust=paymentService.doPay(request);
                        System.out.println("[third] 支付处理结果："+resust);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        PaymentRequest request=new PaymentRequest();
        request.setTotalFee(10000);
        request.setPayMethod(1);
        //被阻塞
        new AsyncPaymentService().submitPay(request);
        System.out.println("处理时长："+(System.currentTimeMillis()-start));

    }



}
