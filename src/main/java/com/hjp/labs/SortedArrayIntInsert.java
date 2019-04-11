package com.hjp.labs;

import java.io.IOException;

//直接插入排序算法
public class SortedArrayIntInsert {
    //排序算法的必要性
    //两个整数按升序排序输出
    public static void sort(int a, int b) {
        if (a < b)
            System.out.println(a + ", " + b);
        else
            System.out.println(b + ", " + a);
    }

    //三个整数按升序排序输出
    public static void sort(int a, int b, int c) {
        if (a < b)
            if (b < c)
                System.out.println(a + "  " + b + "  " + c);
            else if (a < c)
                System.out.println(a + "  " + c + "  " + b);
            else
                System.out.println(c + "  " + a + "  " + b);
        else if (a < c)
            System.out.println(b + "  " + a + "  " + c);
        else if (c < b)
            System.out.println(c + "  " + b + "  " + a);
        else
            System.out.println(b + "  " + c + "  " + a);
    }

    //将key按升序插入到value数组前n个元素中
    public static void insert(int[] value, int n, int key) {
        int i = 0;
        while (i < n && key >= value[i])                      //顺序查找key的插入位置
            i++;
        for (int j = n - 1; j >= i; j--)
            value[j + 1] = value[j];                         //元素向后移动
        value[i] = key;                                     //i是key的插入位置
    }

    public static void print(int[] value, int n) {         //输出数组前n个元素

        for (int i = 0; i < n && i < value.length; i++)
            System.out.print(" " + value[i]);
        System.out.println();
    }

    //从标准输入流中读取表示若干整数的一行字符串，以空格分隔，再调用split()方法分解成字符串数组。
    public static int[] readInt() throws IOException {
        System.out.print("输入无序的整数序列: ");
        byte[] buffer = new byte[512];      //以字节数组作为缓冲区
        int count = System.in.read(buffer);  //从标准输入流中读取若干字节到缓冲区buffer，返回实际读取字节数
        if (count <= 2)                            //输入回车符或^Z
            return null;
        String s = new String(buffer, 0, count - 2);   //由buffer数组中从0开始长度为count-2的若干字节构造串
        String[] str = s.split(" ");  //分解成字符串数组，以空格分隔

        int[] value = new int[str.length];
        int i = 0, j = 0;
        while (i < str.length)
            try {                                          //异常处理语句，存在潜在异常的代码
                value[j] = Integer.parseInt(str[i]);       //调用声明抛出异常的方法
                j++;
            } catch (NumberFormatException e) {               //捕获并处理异常

                System.out.println(str[i] + "字符串不能转换为整数");
            } finally {                           //最后必须执行的代码，无论是否捕获到异常
                i++;
            }
        if (i == j)
            return value;
        int[] keys = new int[j];
        System.arraycopy(value, 0, keys, 0, j);
        //将value数组从0开始的j个元素复制到keys数组从0开始的元素中
        return keys;
    }

    public static void main(String[] args) throws IOException {
        int[] value = readInt();                           //输入一组整数
        for (int i = 0; i < value.length; i++) {
            System.out.print("插入：" + value[i] + ", \t排序序列：");
            insert(value, i, value[i]);                  //将value[i]按升序插入到value数组前i个元素中
            print(value, i+1);                            //输出数组前i+1个元素，方法声明省略
        }
        int key=100;
        int index=ArraySearchInteger.indexOf(value, key);
        System.out.println("顺序查找"+key+", "+(index==-1?"不":"")+"成功");
    }
}
