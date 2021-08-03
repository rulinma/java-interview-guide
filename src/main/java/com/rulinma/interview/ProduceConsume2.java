//package com.rulinma.interview;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @author rollin
// */
//public class ProduceConsume2 {
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
//    private List<Long> objectList = new ArrayList<>();
//
//    private int maxSize = 2;
//
//    private final Lock lock = new ReentrantLock();
//    // 仓库满的条件变量
//    private final Condition full = lock.newCondition();
//    // 仓库空的条件变量
//    private final Condition empty = lock.newCondition();
//
//    public void produce(Long obj) {
//        lock.lock();
//        {
//            while (objectList.size() >= maxSize) {
//                System.out.println("waiting p");
//                try {
//                    full.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            System.out.println("put: " + obj);
//            objectList.add(obj);
//
//            empty.signalAll();
//        }
//        lock.unlock();
//    }
//
//    public void consume() throws InterruptedException {
//        lock.lock();
//        {
//            while (objectList.size() <= 0) {
//                System.out.println("waiting");
//                empty.await();
//                System.out.println("get lock: " + objectList.size());
//            }
//
//            System.out.println("get: " + objectList.remove(0));
//
//            full.signalAll();
//        }
//        lock.unlock();
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