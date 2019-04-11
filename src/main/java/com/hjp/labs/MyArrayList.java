package com.hjp.labs;

import org.omg.CORBA.PRIVATE_MEMBER;

/*
一、ArrayList的底层是Object类的数组，默认长度是10,超过10后，长度变为原长度的2倍+1。

二、可以简单的认为是一个动态数组；实际上ArrayList就是用数组实现的，长度不够时，调用Arrays.copyOf方法，拷        贝当前数组到一个新的长度更大的数组。

三、特点：随机访问速度快，插入和移除性能较差(数组的特点)；

    支持null元素；

    有顺序；

    元素可以重复；

    线程不安全。
    参考：http://blog.csdn.net/smile_juan/article/details/7272841

*/
public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private T[] items;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void ensureCapacity(int newCapacity) {

        if (newCapacity < size()) {
            return;
        }

        T[] oldItems = items;
        items = (T[]) new Object[newCapacity];

        for (int i = 0; i < size(); i++) {
            items[i] = oldItems[i];
        }
    }

    public MyArrayList() {
        clear();
    }

    public void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public T get(int index) {
        if (index <0 || index >= size())
            return null;

        return items[index];
    }

    public T set(int index, T newVal) {
        if (index < 0 || index >= size()) {
            return null;
        } else {
            T old = items[index];
            items[index] = newVal;
            return old;
        }
    }

    public boolean add(T x) {
        add(size(), x);
        return true;
    }

    public void add(int index, T x) {

        if (items.length == size())
            ensureCapacity(size() * 2 + 1);

        for (int i = size(); i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = x;
        size++;
    }

    public void remove(int index) {

        //T removeItem=items[index];
        for (int i = index; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }

        size--;
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<String>();
        list.add("java");
        list.add("c++");
        list.add("c#");
        list.add(2,"php");

        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
