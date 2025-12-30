package com.codegym.task.task25.task2505;

/* 
No idiots

*/

import java.text.Format;

public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("This is an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                String f = String.format("%s, %s, %s", secretKey, t.getName(), e.getMessage());
                System.out.println(f);
            }
        }
    }

}

