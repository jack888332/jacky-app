package demo.debug;

public class MultiThreadDebug {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread(), "A");
        Thread thread2 = new Thread(new MyThread(), "B");
        Thread thread3 = new Thread(new MyThread(), "C");
        thread1.start();
        thread2.start();
        thread3.start();

        // 在主线程上，研究其他线程的状态
        while (true) {
            System.out.println(thread1.getName() + "【" + thread1.getState() + "】");
            System.out.println(thread2.getName() + "【" + thread2.getState() + "】");
            System.out.println(thread3.getName() + "【" + thread3.getState() + "】");
        }
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":start");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":end");
    }
}