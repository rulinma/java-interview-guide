package com.rulinma.interview;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author rollin
 */
public class ProduceConsume4 {
    // Store
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        // Producer
        // Consumer

        Thread t1 = new Thread(producer);
        t1.start();
        Thread t2 = new Thread(producer);
        t2.start();

        Thread c1 = new Thread(consumer);
        c1.start();
        Thread c2 = new Thread(consumer);
        c2.start();
    }

}

class Store {

    private LinkedBlockingQueue<Long> objectList = new LinkedBlockingQueue<Long>(2);

    Semaphore notFull = new Semaphore(10);
    Semaphore notEmpty = new Semaphore(0);

    Semaphore mutex = new Semaphore(1);

    public void produce(Long obj) {
        try {
            notFull.acquire();
            mutex.acquire();
            objectList.put(obj);
            System.out.println("put obj: " + obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notFull.release();
        }
    }

    public void consume() throws InterruptedException {
        try {
            notEmpty.acquire();
            mutex.acquire();
            Long l = objectList.take();
            System.out.println("remove obj: " + l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mutex.release();
            notEmpty.release();
        }
    }

}

class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("run p");
        try {
            for (int i = 0; i < 3; i++) {
                store.produce(System.currentTimeMillis());
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        System.out.println("run c");
        try {
            for (; ; ) {
                store.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}