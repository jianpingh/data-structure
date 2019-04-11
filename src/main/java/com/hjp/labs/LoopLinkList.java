package com.hjp.labs;

//循环单链表类，实现线性表接口
public class LoopLinkList<T> {

    //头指针，指向循环单链表的头结点
    public Node<T> head;

    //默认构造方法，构造空循环单链表
    public LoopLinkList() {
        this.head = new Node<T>();
        this.head.next = this.head;  ////创建头结点
    }

    //判断循环单链表是否空
    public boolean isEmpty() {
        return this.head.next == this.head;
    }

    //由element数组中的多个对象构造单链表。采用尾插入构造单链表
    public LoopLinkList(T[] element) {
        this();                                                  //创建空单链表，只有头结点
        Node<T> rear = this.head;                                //rear指向单链表最后一个结点
        for (int i = 0; i < element.length; i++) {               //若element==null，抛出空对象异常
            //若element.length==0，构造空链表
            rear.next = new Node<T>(element[i], this.head);      //尾插入，创建结点链入rear结点之后
            rear = rear.next;                                    //rear指向新的链尾结点
        }
    }

    //返回循环单链表长度，单链表遍历算法，O(n)
    public int length() {
        int i = 0;
        for (Node<T> p = this.head.next; p != this.head; p = p.next)
            i++;
        return i;
    }

    //返回第i（≥0）个元素，若i<0或大于表长则返回null，O(n)
    public T get(int i) {
        if (i >= 0) {
            Node<T> p = this.head.next;
            for (int j = 0; p != this.head && j < i; j++)
                p = p.next;
            if (p != this.head)
                return p.data;                             //p指向第i个结点
        }
        return null;                                       //当i<0或大于表长时
    }

    //设置第i（≥0）个元素值为x。若i<0或大于表长则抛出序号越界异常；若x==null，不操作。O(n)
    public void set(int i, T x) {
        if (x == null) return;                              //不能设置空对象
        Node<T> p = this.head.next;
        for (int j = 0; p != this.head && j < i; j++)
            p = p.next;
        if (i >= 0 && p != this.head)
            p.data = x;                                    //p指向第i个结点
        else throw new IndexOutOfBoundsException(i + "");    //抛出序号越界异常
    }
}
