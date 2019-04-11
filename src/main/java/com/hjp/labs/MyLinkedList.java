package com.hjp.labs;

public class MyLinkedList<T> {

    /**
     * 结点类
     */
    private static class Node<T> {
        T nodeValue; // 数据域
        Node<T> next; // 指针域保存着下一节点的引用

        Node(T nodeValue, Node<T> next) {
            this.nodeValue = nodeValue;
            this.next = next;
        }

        Node(T nodeValue) {
            this(nodeValue, null);
        }
    }

    // 下面是SingleLinkedList类的数据成员和方法
    private Node<T> head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * 创建头指针，该方法只用一次！
     */
    public void addToHead(T item) {
        head = new Node<T>(item);
        if(tail == null) tail = head;
    }

    /**
     * 添加尾指针，该方法使用多次
     */
    public void addToTail(T item) {
        if (!isEmpty()) { // 若链表非空那么将尾指针的next初使化为一个新的元素
            tail.next = new Node<T>(item); // 然后将尾指针指向现在它自己的下一个元素
            tail = tail.next;
        } else { // 如果为空则创建一个新的！并将头尾同时指向它
            head = tail = new Node<T>(item);
        }
    }

    /**
     * 打印列表
     */
    public void printList() {
        if (isEmpty()) {
            System.out.println("null");
        } else {
            for(Node<T> p = head; p != null; p = p.next)
                System.out.println(p.nodeValue);
        }
    }

    /**
     * 在表头插入结点，效率非常高
     */
    public void addFirst(T item) {
        Node<T> newNode = new Node<T>(item);
        newNode.next = head;
        head = newNode;
    }

    /**
     * 在表尾插入结点，效率很低
     */
    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item);
        Node<T> p = head;
        while (p.next != null) p = p.next;
        p.next = newNode;
        newNode.next = null;
    }

    /**
     * 在表头删除结点，效率非常高
     */
    public void removeFirst() {
        if (!isEmpty()) head = head.next;
        else System.out.println("The list have been emptied!");
    }

    /**
     * 在表尾删除结点，效率很低
     */
    public void removeLast() {
        Node<T> prev = null, curr = head;
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
            if(curr.next == null) prev.next = null;
        }
    }

    /**
     * <p>插入一个新结点</p>
     * <ul>插入操作可能有四种情况:
     * <li>①表为空, 返回false</li>
     * <li>②表非空,指定的数据不存在</li>
     * <li>③指定的数据是表的第一个元素</li>
     * <li>④指定的数据在表的中间</li></ul>
     * @param appointedItem 指定的nodeValue
     * @param item 要插入的结点
     * @return 成功插入返回true;
     */
    public boolean insert(T appointedItem, T item) {
        Node<T>  prev = head, curr = head.next, newNode;
        newNode = new Node<T>(item);
        if(!isEmpty()) {
            while((curr != null) && (!appointedItem.equals(curr.nodeValue))) { //两个判断条件不能换
                prev = curr;
                curr = curr.next;
            }
            newNode.next = curr; //②③④
            prev.next = newNode;
            return true;
        }
        return false; //①
    }

    /**
     * <p>移除此列表中首次出现的指定元素</p>
     * <ul>删除操作可能出现的情况:
     * <li>①prev为空，这意味着curr为head. head = curr.next; --> removeFirst();</li>
     * <li>②匹配出现在列表中的某个中间位置，此时执行的操作是 --> prev.next = curr.next;,</li></ul>
     * <p>在列表中定位某个结点需要两个引用:一个对前一结点(prev左)的引用以及一个对当前结点(curr右)的引用.</p>
     * prev = curr;
     * curr = curr.next;
     */
    public void remove(T item) {
        Node<T> curr = head, prev = null;
        boolean found = false;
        while (curr != null && !found) {
            if (item.equals(curr.nodeValue)) {
                if(prev == null) removeFirst();
                else prev.next = curr.next;
                found = true;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    /**
     * 返回此列表中首次出现的指定元素的索引，如果列表中不包含此元素，则返回 -1.
     */
    public int indexOf(T item) {
        int index = 0;
        Node<T> p;
        for(p = head; p != null; p = p.next) {
            if(item.equals(p.nodeValue))
                return index;
            index++;

        }
        return -1;
    }

    /**
     * 如果此列表包含指定元素，则返回 true。
     */
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    public static void main(String[] args) {
        MyLinkedList<String> t = new MyLinkedList<String>();
        t.addToHead("A");
        //t.addFirst("addFirst");
        t.addToTail("B");
        t.addToTail("C");
        System.out.println(t.indexOf("C")); // 2
        System.out.println(t.contains("A")); // true
        //t.addLast("addLast");
        //t.removeLast();
        //t.insert("B", "insert");
        //t.removeFirst();
        //t.remove("B"); // A C
        t.printList(); // A B C

    }
}