package demo.thread.part4.try_synchronized_method;

import java.util.ArrayList;
import java.util.List;

/**
 * 用调试模式演示各线程的切换过程
 */
public class PublicDataRunner implements Runnable {
    private static int ticket = 20; //多线程访问的公共数据
    private boolean flagForShowThis = true;

    private Object lock = new Object(); //同步锁,线程必须获得该锁，才能执行同步代码块
    private List<Thread> threadList = new ArrayList<>(); //线程组,用于呈现各线程的状态

    public void setThreadList(Thread... threads) {
        for (Thread thread : threads) {
            threadList.add(thread);
        }
    }

    @Override
    public void run() {
        showThis();
        flagForShowThis = false;
        while (true) {
            sellTicket();
            if (ticket <= 0) break;
        }
    }

    /**
     * 同步方法相当于同步代码块
     */
    private synchronized void sellTicket() {
        if (ticket > 0) {
            try {
                Thread.sleep(500); //当前线程挂起
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getAllThreadsInfo() + Thread.currentThread().getName() + "→" + Thread.holdsLock(lock) + ":卖第" + ticket + "张票");
            --ticket;
        }
    }

//    private void sellTicket1() {
//        synchronized (this) {
//            if (ticket > 0) {
//                try {
//                    Thread.sleep(500); //当前线程挂起
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(getAllThreadsInfo() + Thread.currentThread().getName() + "→" + Thread.holdsLock(lock) + ":卖第" + ticket + "张票");
//                --ticket;
//            }
//        }
//    }

    private synchronized void showThis() {
        if (flagForShowThis) {
            System.out.println(this);
        }
    }

    private String getAllThreadsInfo() {
        String allThreadsInfo = "";
        for (Thread thread : threadList) {
            String threadInfo = thread.getName() + "【" + thread.getState() + "】,";
            allThreadsInfo += threadInfo;
        }
        return allThreadsInfo;
    }
}