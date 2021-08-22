//package com.rulinma.interview;
//
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @author rollin
// */
//public class ProduceConsume3 {
//    // Store
//    public static void main(String[] args) {
//        Store store = new Store();
//        Producer producer = new Producer(store);
//        Consumer consumer = new Consumer(store);
//        // Producer
//        // Consumer
//
//        Thread t1 = new Thread(producer);
//        t1.start();
//        Thread t2 = new Thread(producer);
//        t2.start();
//
//        Thread c1 = new Thread(consumer);
//        c1.start();
//        Thread c2 = new Thread(consumer);
//        c2.start();
//    }
//
//}
//
//class Store {
//
//    private LinkedBlockingQueue<Long> objectList = new LinkedBlockingQueue<Long>(2);
//
//    private final Lock lock = new ReentrantLock();
//
//    public void produce(Long obj) {
//        try {
//            objectList.put(obj);
//            System.out.println("put obj: " + obj);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void consume() throws InterruptedException {
//        Long l = objectList.take();
//        System.out.println("remove obj: " + l);
//    }
//
//}
//
//class Producer implements Runnable {
//    private Store store;
//
//    public Producer(Store store) {
//        this.store = store;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("run p");
//        try {
//            for (int i = 0; i < 3; i++) {
//                store.produce(System.currentTimeMillis());
//                Thread.sleep(10);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
//class Consumer implements Runnable {
//    private Store store;
//
//    public Consumer(Store store) {
//        this.store = store;
//    }
//
//    @Override
//    public void run() {
//        System.out.println("run c");
//        try {
//            for (; ; ) {
//                store.consume();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}