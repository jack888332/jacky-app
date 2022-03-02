package demo.thread.part2.unsafety_between_threads;

/**
 * 当多个线程修改公共数据时，可能会导致数据错乱或越界
 * 要避免线程安全问题，就必须确保同时只有一个线程在执行修改公共数据的事务
 */
public class ThreadsForModifyPublicData {
    public static void main(String[] args) {
        PublicDataRunner pdr = new PublicDataRunner();

        // 多个线程运行同一份执行代码
        Thread thread1 = new Thread(pdr);
        Thread thread2 = new Thread(pdr);
        Thread thread3 = new Thread(pdr);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
