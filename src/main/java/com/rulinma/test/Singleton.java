package com.rulinma.test;

/**
 * @author rollin
 *
 * @see https://blog.csdn.net/xdzhouxin/article/details/81192344
 * @see https://blog.csdn.net/u010660307/article/details/69922320
 */
public class Singleton {

    private volatile static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            // 假设多线程情况，则这里会可能创建不同的实例，所以需要同步
            synchronized (Singleton.class) {
                // double check
                if (instance == null) {
                    //
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}
