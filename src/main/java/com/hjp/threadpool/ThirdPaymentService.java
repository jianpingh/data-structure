package com.hjp.threadpool;

/**
 * 第三方支付通道
 * 外部平台
 */
public class ThirdPaymentService {


    public String doPay(PaymentRequest request){
        System.out.println("[Third] 处理支付请求："+request);
        try {
            Thread.sleep(2000); //支付业务逻辑处理需要消耗2s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "SUCCESS";
    }

}
