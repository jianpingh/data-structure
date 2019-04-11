package com.hjp.labs;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class test {

    public static void main(String[] args) {
        int [] a = {2,1,3,2,0,4,2,1,2,3,1,5,6,2,2,3};
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<a.length; i++){
            if(map.containsKey(a[i])){
                int tmp = map.get(a[i]);
                tmp+=1;
                map.put(a[i], tmp);
            }else{
                map.put(a[i], 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer s : set) {
            if(map.get(s)>=a.length/2){
                System.out.println(s);
            }
        }

        Thread thread=new Thread();


    }
}
