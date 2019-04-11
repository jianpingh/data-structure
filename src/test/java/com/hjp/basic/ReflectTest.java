package com.hjp.basic;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    @Test
    public void testReflect() {

        //调用getClass
        Boolean var1 = true;
        Class<?> classType2 = var1.getClass();
        System.out.println(classType2);

        //运用.class 语法
        Class<?> classType4 = Boolean.class;
        System.out.println(classType4);

        //运用static method Class.forName()
        try {
            Class<?> classType5 = Class.forName("java.lang.Boolean");
            System.out.println(classType5);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getStackTrace());
        }

        //运用primitive wrapper classes的TYPE 语法
        Class<?> classType3 = Boolean.TYPE;
        System.out.println(classType3);

        Class<?> classType = ExtendType.class;

        // 使用getFields获取属性
        Field[] fields = classType.getFields();
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println();

        // 使用getDeclaredFields获取属性
        fields = classType.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f);
        }
    }

    @Test
    public void testReflect2() {
        // 使用getMethods获取函数
        Class<?> classType = ExtendType.class;
        Method[] methods = classType.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println();

        // 使用getDeclaredMethods获取函数
        methods = classType.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }

        // 使用getConstructors获取构造器
        Constructor<?>[] constructors = classType.getConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }

        System.out.println("使用getDeclaredConstructors获取构造器");

        // 使用getDeclaredConstructors获取构造器
        constructors = classType.getDeclaredConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }
    }

    @Test
    public void testReflectNewInstance() {

        //1、调用类的Class对象的newInstance方法，该方法会调用对象的默认构造器，如果没有默认构造器，会调用失败.
        Class<?> classType = ExtendType.class;
        Object inst = null;
        try {
            inst = classType.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(inst);

        //2、调用默认Constructor对象的newInstance方法
        Class<?> classType2 = ExtendType.class;
        try {
            Constructor<?> constructor2 = classType2.getConstructor();
            Object inst2 = constructor2.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(inst);

        //3、调用带参数Constructor对象的newInstance方法
        try {
            Constructor<?> constructor3 = classType.getDeclaredConstructor(int.class, String.class);
            try {
                Object inst3 = constructor3.newInstance(1, "123");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        System.out.println(inst);
    }

    @Test
    public void testReflectInvoke(){
        Class<?> classType=ExtendType.class;
        try {
            Object inst = classType.newInstance();
            Method logMethod = classType.getDeclaredMethod("Log", String.class);
            try {
                logMethod.setAccessible(true);
                logMethod.invoke(inst, "test");
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }



    }
}
