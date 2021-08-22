package com.rulinma.test;

/**
 * @author rollin
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
            {
                System.out.println("xxx:" + Thread.currentThread().isInterrupted());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // 捕获异常后就自动重置了flag？
                    e.printStackTrace();
                    System.out.println("xxx1:" + Thread.currentThread().isInterrupted());
                    // 收到中断信息
                    // restore interrupt
                    Thread.currentThread().interrupt();
                    System.out.println("xxx2:" + Thread.currentThread().isInterrupted());
                    // true
//                    System.out.println("xxx2:" + Thread.interrupted());
                }
            }
            System.out.println("yyy");
        });

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("vv:" + thread.isInterrupted());
        System.out.println("end");
    }
}
