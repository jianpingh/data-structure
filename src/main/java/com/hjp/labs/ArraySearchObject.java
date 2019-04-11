package com.hjp.labs;

//对象数组的顺序查找算法
public class ArraySearchObject {

    //在对象数组value中查找key对象，若查找成功返回元素下标，否则返回-1
    //若value或key为null，将抛出空对象异常NullPointerException
    public static int indexOf(Object[] value, Object key) {
        for (int i = 0; i < value.length; i++)
            if (key.equals(value[i]))                     //对象采用equals()方法比较相等
                return i;
        return -1;
    }

    //输出对象数组元素
    public static void print(Object[] value) {
        for (int i = 0; i < value.length; i++)
            System.out.print(" " + value[i].toString());    //输出对象默认执行其toString()方法
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] value = {32, 15, 78, 99, 87, 34, 14, 19, 76, 46, 1};
        System.out.print("随机数序列: ");
        print(value);
        Object key = 99;//new Integer(99);
        System.out.println("顺序查找 " + key + ", " + ((indexOf(value, key) == -1) ? "不" : "") + "成功");
    }
}
