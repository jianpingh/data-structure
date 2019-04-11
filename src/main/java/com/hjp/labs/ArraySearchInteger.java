package com.hjp.labs;

//整数数组的顺序查找算法
public class ArraySearchInteger {

    public static int[] random(int n) {
        if (n < 0)
            return null;
        int[] value = new int[n];

        for (int i = 0; i < value.length; i++) {
            value[i] = (int) (Math.random() * 100);
        }

        return value;
    }

    //输出数组元素
    public static void print(int[] value) {
        for (int i : value)
            System.out.println(i);

    }

    //在整数数组value中查找key值，若查找成功返回元素下标，否则返回-1
    public static int indexOf(int[] value, int key) {
        for (int i = 0; i < value.length; i++) {               //若value==null，将抛出空对象异常NullPointerException
            //System.out.print(value[i] + "? ");
            if (value[i] == key)                             //基本数据类型采用==、!=运算符比较相等
                return i;
        }
        return -1;
    }

    //产生n个互异随机数，范围是1～size，返回整型数组
    public static int[] randomDifferent(int n, int size)
    {
        int value[]=new int[n], i=0;
        while (i<value.length)
        {
            int key=(int)(Math.random()*size);
            if (indexOf(value, key)==-1)               //顺序查找不成功
                value[i++] = key;
        }
        return value;
    }

    public static void main(String args[]) {
        int[] value =randomDifferent(6,200);
        System.out.print("随机数序列: ");
        print(value);
        int key=value[value.length/2];
        System.out.println("顺序查找 "+key+", "+((indexOf(value,key)==-1)?"不":"")+"成功");
        key=25;
        System.out.println("顺序查找 "+key+", "+((indexOf(value,key)==-1)?"不":"")+"成功");
    }
}
