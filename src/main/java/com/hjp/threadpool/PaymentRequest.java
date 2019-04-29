package com.hjp.threadpool;

/**
 */
public class PaymentRequest {

    private int totalFee; //分为单位

    private int payMethod; //支付方式

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "PaymentRequest{" +
                "totalFee=" + totalFee +
                ", payMethod=" + payMethod +
                '}';
    }
}
