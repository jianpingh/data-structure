package com.hjp.luban.aop;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther huang jianping
 * @date 2019/6/6 14:42
 * 参考：https://blog.csdn.net/u010452388/article/details/80868392
 */
public class App {

    @Test
    public void test1() {

        final UserDao userDao = new UserDaoImpl();
        // newProxyInstance的三个参数解释：
        // 参数1：代理类的类加载器，同目标类的类加载器
        // 参数2：代理类要实现的接口列表，同目标类实现的接口列表
        // 参数3：回调，是一个InvocationHandler接口的实现对象，当调用代理对象的方法时，执行的是回调中的invoke方法
        //proxy为代理对象
        UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
                userDao.getClass().getInterfaces(), new InvocationHandler() {

                    @Override
                    // 参数proxy:被代理的对象
                    // 参数method:执行的方法，代理对象执行哪个方法，method就是哪个方法
                    // 参数args:执行方法的参数
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("记录日志");
                        Object result = method.invoke(userDao, args);
                        return result;
                    }
                });
        //代理对象执行方法
        proxy.saveUser();
    }

    @Test
    public void test2() {
        final LinkManDao linkManDao = new LinkManDao();
        // 创建cglib核心对象
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(linkManDao.getClass());
        // 设置回调
        enhancer.setCallback(new MethodInterceptor() {
            /**
             * 当你调用目标方法时，实质上是调用该方法
             * intercept四个参数：
             * proxy:代理对象
             * method:目标方法
             * args：目标方法的形参
             * methodProxy:代理方法
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
                    throws Throwable {
                System.out.println("记录日志");
                Object result = method.invoke(linkManDao, args);
                return result;
            }
        });
        // 创建代理对象
        LinkManDao proxy = (LinkManDao) enhancer.create();
        proxy.save();
    }
}
