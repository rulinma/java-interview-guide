//package com.rulinma.interview;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author rollin
// */
//public class ProduceConsume {
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
////        Thread t3 = new Thread(producer);
////        t3.start();
////        Thread t4 = new Thread(producer);
////        t4.start();
////        Thread t5 = new Thread(producer);
////        t5.start();
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
//    public void produce(Long obj) throws InterruptedException {
//        synchronized (objectList) {
//            while (objectList.size() >= maxSize) {
//                System.out.println("waiting p");
//                objectList.wait();
//            }
//
//            System.out.println("put: " + obj);
//            objectList.add(obj);
//
//            objectList.notifyAll();
//        }
//    }
//
//    public void consume() throws InterruptedException {
//        synchronized (objectList) {
//            while (objectList.size() <= 0) {
//                System.out.println("waiting");
//                objectList.wait();
//                System.out.println("get lock: " + objectList.size());
//            }
//
////            while (objectList.size() <= 0) {
////                System.out.println("waiting");
////                objectList.wait();
////            }
//
//            System.out.println("get: " + objectList.remove(0));
//
//            objectList.notifyAll();
//        }
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