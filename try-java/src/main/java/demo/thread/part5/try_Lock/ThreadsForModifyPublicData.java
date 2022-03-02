package demo.thread.part5.try_Lock;

/**
 * 当多个线程修改公共数据时，可能会导致数据错乱或越界
 * 要避免线程安全问题，就必须确保同时只有一个线程在执行修改公共数据的事务
 * 用调试模式演示
 */
public class ThreadsForModifyPublicData {
    public static void main(String[] args) {
        // 公共数据运行器
        PublicDataRunner pdr = new PublicDataRunner();
        System.out.println(pdr);

        // 多个线程运行同一份执行代码
        Thread thread1 = new Thread(pdr, "A");
        Thread thread2 = new Thread(pdr, "B");
        Thread thread3 = new Thread(pdr, "C");
        Thread thread4 = new Thread(pdr, "D");

        pdr.setThreadList(thread1, thread2, thread3, thread4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
