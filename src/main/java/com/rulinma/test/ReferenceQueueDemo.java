package com.rulinma.test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author rollin
 */
public class ReferenceQueueDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        WeakReference<Object> weakReference = new WeakReference<>(o1, referenceQueue);
        System.out.println("***************GC回收前***************");
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println("referenceQueue: " + referenceQueue.poll());

        System.out.println("***************启动GC***************");
        o1 = null;
        System.gc();
        try {
            Thread.sleep(500);
            // 确保GC都执行完了
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println("referenceQueue: " + referenceQueue.poll());

        System.out.println("end");
    }
}
