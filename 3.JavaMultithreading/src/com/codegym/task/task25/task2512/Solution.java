package com.codegym.task.task25.task2512;

/* 
Charting our own course

*/


import java.util.ArrayList;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        List<Throwable> list = new ArrayList<>();
        while (e!=null){
            list.add(e);
            e=e.getCause();
        }
        for (int i = list.size()-1;i>-1;i--){
            System.out.println(list.get(i).toString());
        }

    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread()
        {
            public void run()
            {
                throw new RuntimeException("ABC", new Exception("DEF", new IllegalAccessException("GHI")));
            }
        };
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
            public void uncaughtException(Thread t, Throwable e) {
                t.interrupt();
                List<Throwable> list = new ArrayList<>();
                while (e!=null){
                    list.add(e);
                    e=e.getCause();
                }
                for (int i = list.size()-1;i>-1;i--){
                    System.out.println(list.get(i).toString());
                }
            }
        });
        t.start();
    }
}
