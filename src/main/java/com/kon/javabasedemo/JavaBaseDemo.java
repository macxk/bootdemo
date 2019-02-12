package com.kon.javabasedemo;

/**
 * Created by xk on 2018/10/7.
 */
public class JavaBaseDemo {

    public static void StringConcatenateDemo1(){

        long startTime = System.currentTimeMillis();
        for(int i=0;i<5000;i++){

            String result = "i" +
                    "will"+
                    "be"+
                    "well!";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用+操作符连接字符串用时:"+(endTime-startTime)+"ms");

        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<5000;i++){

            StringBuffer result = new StringBuffer();
            result.append("i").append("will").append("be").append("well!");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用Stringbuffer连接字符串用时:"+(endTime1-startTime1)+"ms");

    }

    public static void StringConcatenateDemo2(){

        String result1;
        StringBuffer result2 = new StringBuffer();

        long startTime = System.currentTimeMillis();
        for(int i=0;i<50000;i++){

             result1 = "i" +
                    "will"+
                    "be"+
                    "well!";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用+操作符连接字符串用时:"+(endTime-startTime)+"ms");

        long startTime1 = System.currentTimeMillis();
        for(int i=0;i<50000;i++){


            result2.append("i").append("will").append("be").append("well!");
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用Stringbuffer连接字符串用时:"+(endTime1-startTime1)+"ms");

    }

    public static void doTowersDemo(int topN,String from,String inner,String to){

        if(topN==1){
            System.out.println("disk 1 from "+from+" to "+to);
        }else{
            doTowersDemo(topN-1,from,to,inner);
            System.out.println("disk " +topN+ " from "+from+" to "+to);
            doTowersDemo(topN-1,inner,from,to);
        }
    }


    public static void main(String[] a){

        StringConcatenateDemo1();
        StringConcatenateDemo2();
        doTowersDemo(3,"A","B","C");
    }
}
