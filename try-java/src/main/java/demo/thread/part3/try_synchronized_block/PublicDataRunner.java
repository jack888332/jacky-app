package demo.thread.part3.try_synchronized_block;

import java.util.ArrayList;
import java.util.List;

/**
 * 用调试模式演示各线程的切换过程
 */
public class PublicDataRunner implements Runnable {
    private int ticket = 20; //多线程访问的公共数据

    private Object lock = new Object(); //同步锁,线程必须获得该锁，才能执行同步代码块
    private List<Thread> threadList = new ArrayList<>(); //线程组,用于呈现各线程的状态

    public void setThreadList(Thread... threads) {
        for (Thread thread : threads) {
            threadList.add(thread);
        }
    }

    @Override
    public void run() {
        while (true) {
            /**
             * 在每句代码的位置，CPU都允许相关线程抢占其使用。只有抢占到CPU使用权的线程才会执行该语句。
             * 比如，在29行代码的位置，线程的先占顺序： A → C → D → A,  B没抢占到
             * 则：A/C/D线程打印第30行代码，然后A抢夺同步锁，进入同步代码块，其他尝试执行同步代码块的线程都会变为BLOCKED
             * A执行完同步代码块，释放同步锁，后续让任意线程抢夺同步锁
             */
            System.out.println("# " + getAllThreadsInfo());

            synchronized (lock) {
                System.out.println("# " + getAllThreadsInfo());
                if (ticket > 0) {
                    try {
                        Thread.sleep(10000); //当前线程挂起
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getAllThreadsInfo() + Thread.currentThread().getName() + "→" + Thread.holdsLock(lock) + ":卖第" + ticket + "张票");
                    --ticket;
                } else {
                    break;
                }
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