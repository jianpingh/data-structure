package com.hjp.labs;

public class LoopLinkListTest {

    public static void main(String args[]){

        Integer[] array=new Integer[]{12,25,55,78,99,-17};
        LoopLinkList<Integer> linkList =new  LoopLinkList<Integer>(array);

        int length=linkList.length();
        int a=linkList.get(5);

        System.out.println("链表是否为空："+linkList.isEmpty());
        System.out.println("链表长度是："+length);
        System.out.println("获取指定位置的数据是："+a);

        for(int i=0;i<length;i++)
            System.out.println(linkList.get(i));

        linkList.set(1,200);

        for(int i=0;i<length;i++)
            System.out.println(linkList.get(i));
    }
}
