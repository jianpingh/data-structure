package com.hjp.design.parttern;

//双重校验锁(jdk1.5)
public class Singleton3 {
    private volatile static Singleton3 singleton;
    private Singleton3 (){}
    public static Singleton3 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
