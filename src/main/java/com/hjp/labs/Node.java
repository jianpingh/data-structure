package com.hjp.labs;

//单链表结点类
public class Node<T> {             //单链表结点类，T指定结点的元素类型

    public T data;                 //数据域，保存数据元素
    public Node<T> next;           //地址域，后任结点引用

    //构造结点，data指定数据元素，next指定后继结点
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node() {
        this(null, null);
    }

    //返回结点对应的字符串
    public String toString() {
        return this.data.toString();
    }

    //比较两个结点值是否相等，覆盖Object类的equals(obj)方法
    public boolean equals(Object obj) {
        return obj == this || obj instanceof Node && this.data.equals(((Node<T>) obj).data);
    }
}





























