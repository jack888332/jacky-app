package demo.thread.part2.unsafety_between_threads;

public class PublicDataRunner implements Runnable {
    private int ticket = 10; //多线程访问的公共数据

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(50); //当前线程挂起
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":正在卖第" + ticket + "张票");
                --ticket;
            } else {
                break;
            }
        }
    }
}