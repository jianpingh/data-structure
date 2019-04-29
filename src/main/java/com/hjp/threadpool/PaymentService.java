package com.hjp.threadpool;

/**
 *  内部平台
 */
public class PaymentService {

    ThirdPaymentService paymentService=new ThirdPaymentService();

    public String submitPay(PaymentRequest request){
        // 实名认证的判断
        // 绑卡的判断
        // 账户安全的判断(风控）
        System.out.println("开始处理支付请求："+request);
        return paymentService.doPay(request);
    }

    public static void main(String[] args) {
        long start=System.currentTimeMillis();

        PaymentRequest request=new PaymentRequest();
        request.setTotalFee(10000);
        request.setPayMethod(1);
        //被阻塞
        new PaymentService().submitPay(request);
        System.out.println("处理时长："+(System.currentTimeMillis()-start));
    }

}
