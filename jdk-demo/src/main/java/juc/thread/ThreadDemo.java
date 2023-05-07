package juc.thread;

import org.junit.Test;

public class ThreadDemo {

    @Test
    public void test() {

        /**
         * 默认都是用户线程
         */
        Thread t1 = new Thread(() -> {
        }, "t1");

        /**
         * 设置为守护线程
         */
        t1.setDaemon(true);
        /**
         * 是否是守护线程
         */
        if (t1.isDaemon()) {
            System.out.println("is daemon");
        }
        /**
         * 线程是否或者
         */
        if (t1.isAlive()) {
            System.out.println("is alive");
        }
        /**
         * 是否被中断
         */
        if (t1.isInterrupted()) {
            System.out.println("is interrupt");
        }
        /**
         * 是否是虚拟线程
         */
//        if (t1.isVirtual()) {
//            System.out.println("is virtual");
//        }




    }
}
