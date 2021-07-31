package com.rulinma.interview.voliatedemo;

/**
 * @author rollin
 */
public class VoliateTest {

    public static void main(String[] args) {
        VoliateDemo voliateDemo = new VoliateDemo();
        voliateDemo.start();
        for (; ; ) {
            // 有没有下面这行，会影响执行结果
            System.out.println("current flag: " + voliateDemo.isFlag());
//            System.out.println("current flag: ");
            if (voliateDemo.isFlag()) {
                System.out.println("flag changed");
            }
        }
    }
}

class VoliateDemo extends Thread {
    private boolean flag = false;
//    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag: " + flag);
    }
}
