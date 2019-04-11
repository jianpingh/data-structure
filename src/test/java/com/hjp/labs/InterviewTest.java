package com.hjp.labs;

import javafx.beans.binding.StringBinding;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;

public class InterviewTest {

    @Test
    public void testString(){

        String str="test";
        String str2=new String("test2");
        StringBuffer buffer=new StringBuffer();
        StringBuilder sb=new StringBuilder();
        Collections collections;
    }

    @Test
    public void testThraed(){
        Thread t = new Thread() {

            public void run() {
                pong();
            }

       };
    t.start();
        System.out.print("ping");
    }

    static void pong() {

        System.out.print("pong");

    }

    @Test
    public void testStringObj(){
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
        System.err.println(str1.equals(str2));
    }

    @Test
    public void getValue() {
        int i=2;
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
        }

        System.out.print(result);
    }

    @Test
    public void GetCountForBinaryContains(){

        int n=124455;
        String result = Integer.toBinaryString(n);
        System.out.println(result);
        int count=0;
        for(int i=0;i<result.length();i++){
            if(result.substring(i,i+1).equals("1")){
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public  void testArray(){
        int[] num=new int[3];
        System.out.println(num.length);
        //System.out.println(num.);
    }

    @Test
    public void testString2(){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
    }


    @Test
    public void testString3() {
        Calendar cal = Calendar.getInstance();
    }




















}
