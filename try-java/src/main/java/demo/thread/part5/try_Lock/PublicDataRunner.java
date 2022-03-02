package demo.thread.part5.try_Lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用调试模式演示各线程的切换过程
 */
public class PublicDataRunner implements Runnable {
    private static int ticket = 20; //多线程访问的公共数据

    Lock lock = new ReentrantLock();
    private List<Thread> threadList = new ArrayList<>(); //线程组,用于呈现各线程的状态

    public void setThreadList(Thread... threads) {
        for (Thread thread : threads) {
            threadList.add(thread);
        }
    }

    @Override
    public void run() {
        while (true) {
            sellTicket();
            if (ticket <= 0) break;
        }
    }

    /**
     * 同步方法相当于同步代码块
     */
    private void sellTicket() {
        lock.lock();
        if (ticket > 0) {
            try {
                Thread.sleep(500); //当前线程挂起
                System.out.println(getAllThreadsInfo() + Thread.currentThread().getName() + "→" + Thread.holdsLock(lock) + ":卖第" + ticket + "张票");
                --ticket;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
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