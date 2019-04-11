package com.hjp.basic;

public class HelloWorld {
    public static void main(String[] args) {

        HelloWorld hl=new HelloWorld();
        System.out.println("Hello World");

        hl.test();

    }

    public  void test(){
        System.out.println(this.getClass().getClassLoader().getResource("").toString());
    }
}
