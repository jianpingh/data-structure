package com.hjp.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicSubject implements InvocationHandler {
    private Object sub;

    public DynamicSubject(Object obj) {
        this.sub = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Method:" + method + ",Args:" + args);
        method.invoke(sub, args);
        return null;
    }

    public static void main(String[] args) {
        RealSubject realSub = new RealSubject();
        InvocationHandler handler = new DynamicSubject(realSub);
        Class<?> classType = handler.getClass();
        Subject sub = (Subject) Proxy.newProxyInstance(classType.getClassLoader(),
                realSub.getClass().getInterfaces(), handler);
        System.out.println(sub.getClass());
        sub.Request();

    }
}