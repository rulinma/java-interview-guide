package com.rulinma.interview;

/**
 * @author rollin
 */
public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("xxx:" + Thread.interrupted());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
//                    System.out.println("xxx1:" + Thread.interrupted());
                    // 收到中断信息
                    Thread.currentThread().interrupt();
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
    }
}
